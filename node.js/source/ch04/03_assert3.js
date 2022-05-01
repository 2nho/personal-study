const assert = require("assert");

assert.throws(
    function() {
        throw new Error("Wrong value");
        // console.log("currect value"); // error
    },
    Error
);


assert.doesNotThrow(
    function() {
        console.log("Nothing to see here");
        // throw new Error("Something to see here"); // error
    },
    Error
);


// assert.fail("error!"); // error



