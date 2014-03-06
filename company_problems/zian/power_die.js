/*
 * power_die.js
 * ian zapolsky - 3/4/12
*/

var power_die = function() {

  var roll;

  // simulate a die, instantiating anew with each call to roll()
  roll = function(n, sides) {
    var die = [];
    die[0] = n; 
    for (var i=1; i<sides; i++)
      die[i] = (die[i-1] * n); 

    var result = Math.floor(Math.random()*sides);
    console.log(result);
    return die[result];
  }

  // the first name is passed to the context above this function
  return { roll : roll };

}();


