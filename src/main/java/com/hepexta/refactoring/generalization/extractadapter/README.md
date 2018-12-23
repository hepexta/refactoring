**EXTRACT ADAPTER**

One class adapts multiple versions of a
component, library, API, or other entity.

`Extract an Adapter for a single version of the
component, library, API, or other entity.`

Systems that depend on multiple versions of a component, library, or API tend to have a good deal of version-dependent logic scattered throughout the code (a sure sign of the Solution Sprawl smell, 43). While you wouldn’t want to complicate a design by refactoring to Adapter too early, it’s useful to apply this refactoring as soon as you find complexity, propagating conditionality, or a maintanance issue resulting from code written to handle multiple versions.

**Benefits and Liabilities**

+  Isolates differences in versions of a component, library, or API.

+  Makes classes responsible for adapting only one version of something.

+  Provides insulation from frequently changing code.

–  Can shield a client from important behavior that isn’t available on the Adapter.