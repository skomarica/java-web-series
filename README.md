## Software Stack

1. JDK 1.7.x
2. Eclipse 4.4+ or Spring Tool Suite 3.6+
3. Gradle plugin for Eclipse

## Prepare IDE

### Workspace

- Select workspace (e.g. `.../java/workspace/java-web-series`)

### Git

- Enable Git Repositories view: `Windows -> Show View -> Other... -> Git Repositories`
- Clone a Git Repository `https://github.com/skomarica/java-web-series.git` to the local repository folder (e.g. `.../git/java/java-web-series`)

### Preferences

- `Java -> Installed JREs`: add JDK 1.7.x and make it default
- `Java -> Compiler`: Set Compiler compliance level to 1.7
- `Gradle -> Arguments`: Check `Workspace JRE (jdk1.7.x_yz)` under Java Home section
- `Java -> Code Style -> Formatter`: Import `.../git/java/java-web-series/tools/eclipse/modified-spring-code-conventions.xml` formatter
- `General -> Editors -> Text Editors`: check `Insert spaces for tabs`
- `XML -> XML Files -> Editor`: set `Line width` to `120`
- `Web -> HTML Files -> Editor`: set `Line width` to `240`
- `Java -> Editor -> Save Actions`: Check `Perform the selected actions on save` (`Format source code` with `Format all lines` and `Organize imports` should be checked)

### Importing projects

- `Import -> Gradle Project`: Select root folder `.../git/java/java-web-series` and run `Build Model`
- Select projects and import with default options
