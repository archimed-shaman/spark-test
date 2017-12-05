You need sbt, java and scala to be installed.

###### To build:
```
sbt compile
```

###### To assembly jar for spark:
```
sbt assembly
```

###### Emacs & ensime:

Add the plugin to your global sbt config (e.g. ~/.sbt/0.13/plugins/plugins.sbt):
```
resolvers += Resolver.sonatypeRepo("snapshots")
addSbtPlugin("org.ensime" % "ensime-sbt" % "0.1.5-SNAPSHOT")
```
Generate project:
```
sbt ensimeConfig
```

###### SBT and Spark

Plugin for spark is already included in the project, you can start local spark task like
```
sbt "sparkSubmit --master local[2] --class Main -- <arguments>"
```

You can find more information [here](http://www.troikatech.com/blog/2014/11/26/ensime-and-emacs-as-a-scala-ide).
