#Zip Code Range Optimization

###Code Organisation
* Main class is the starting point and has a main method to execute.
* The `ZipCodeRangeService` class is created as a `Singleton`, since there is no need of multiple objects of a service class.

* The main method just calls the `ZipCodeRangeService.getOptimizedRanges()` to optimize the zip code ranges.

###Assumptions and Design Choices
* `ZipCodeRange` is a class with start and end as attributes
* Input is an array of ZipCodeRange objects and may not be sorted

### Steps ( Algorithm )
* Step 1: Sort by start value
* Step 2: find overlaps and merge
* Step 3: return the merged collection ( array )

