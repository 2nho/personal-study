function foo() {
    function bar() {
      console.trace("my word");
    }
    bar();
  }
  
  foo();
