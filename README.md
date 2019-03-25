# scoverage-scalajs-node-jsdom-example

Test project for https://github.com/scoverage/scalac-scoverage-plugin/issues/183

Run `npm install jsdom` before building.

Run all the tests and see the coverage:
```bash
sbt clean coverage test coverageReport && sbt coverageAggregate
```
