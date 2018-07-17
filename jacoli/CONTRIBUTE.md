# ReMap - How to contribute

First of all: Feel free to contribute to this project! We appreciate any help to develop this library and make it nice, stable and feature complete.

The Java Compare Library was started to minimize the need of converter classes and corresponding unit tests. There are features that require a user to write tests and therefore are not added to the library. We try to check every new feature carefully before merging pull requests!

This project provides a checkstyle rule configuration as well as formatter configurations for Eclipse and IntelliJ IDEA.

The formatter configurations of both supported IDEs were created to produce similar outputs. Although there are slightly different formattings, the outputs should be compliant to the Checkstyle rule set.

## Contributing Features

When contributing features, any suggestions to extend the README of this project are welcome :-)

### Testing features

When writing test for this project, please make sure to create a new package for your test. This avoids unnecessary dependencies to other test classes.

## Contributing bug fixes

When contributing bug fixes, please first write a test that provokes the bug. Please use the package `com.github.schuettec.compare` for that.

## Contribution resources

You can find the IDE formatter and the Checkstyle rule set in `shared/config`.
