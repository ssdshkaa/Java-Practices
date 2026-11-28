param(
    [string]$Jdk = $env:JAVA_HOME,
    [switch]$Gui,
    [switch]$Full
)

$ErrorActionPreference = 'Stop'
if (-not $Jdk) {
    $compiler = Get-Command javac -ErrorAction SilentlyContinue
    if ($compiler) {
        $Jdk = Split-Path (Split-Path $compiler.Source)
    } elseif (Test-Path 'C:\Program Files\JetBrains\IntelliJ IDEA 2026.2.3\jbr\bin\javac.exe') {
        $Jdk = 'C:\Program Files\JetBrains\IntelliJ IDEA 2026.2.3\jbr'
    } else {
        throw 'Укажите JDK: .\check.ps1 -Jdk C:\path\to\jdk'
    }
}

$repo = Split-Path $PSScriptRoot
$build = Join-Path $PSScriptRoot 'out'
New-Item -ItemType Directory -Force $build | Out-Null
$files = Get-ChildItem (Join-Path $repo 'Practical_Work_1'), (Join-Path $repo 'Practical_Work_2'), $PSScriptRoot -Recurse -Filter '*.java'
$argumentsFile = Join-Path $build 'sources.txt'
$sourcePaths = $files | ForEach-Object { '"' + $_.FullName.Replace('\', '/') + '"' }
$utf8 = New-Object System.Text.UTF8Encoding($false)
[System.IO.File]::WriteAllLines($argumentsFile, [string[]]$sourcePaths, $utf8)
& "$Jdk\bin\javac.exe" -encoding UTF-8 -d $build "@$argumentsFile"
if ($LASTEXITCODE -ne 0) {
    throw 'Ошибка компиляции'
}
Write-Output "Скомпилировано Java-файлов: $($files.Count)"

Push-Location $PSScriptRoot
try {
    $classes = @('Work3Checks', 'ru.mirea.work3.part2.Task1Static',
        'ru.mirea.work3.part2.Task2Static', 'ru.mirea.work3.part2.Task3Static',
        'ru.mirea.work3.part2.Task4Date',
        'ru.mirea.work3.part2.Task5CircleArray', 'ru.mirea.work3.part2.Task6StopWatchDemo',
        'ru.mirea.work3.part2.Task7SelectionSort', 'ru.mirea.work3.part3.NestedClassesDemo')
    if ($Gui) {
        $classes += 'SwingChecks'
    }
    foreach ($class in $classes) {
        & "$Jdk\bin\java.exe" '-Dstdout.encoding=UTF-8' '-Dstderr.encoding=UTF-8' -cp $build $class
        if ($LASTEXITCODE -ne 0) {
            throw "Ошибка проверки $class"
        }
    }
    if ($Full) {
        & "$Jdk\bin\java.exe" '-Dstdout.encoding=UTF-8' -cp $build ru.mirea.work3.part2.Task7SelectionSort --full
        if ($LASTEXITCODE -ne 0) {
            throw 'Ошибка полной сортировки'
        }
    }
    [xml](Get-Content (Join-Path $PSScriptRoot 'uml/StopWatch.drawio') -Raw) | Out-Null
    Write-Output 'Проверки завершены'
} finally {
    Pop-Location
}
