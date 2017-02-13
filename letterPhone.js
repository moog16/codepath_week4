function letterCombinations(digits) {
  var numsToLetters = {
    2: ['a', 'b', 'c'],
    3: ['d', 'e', 'f'],
    4: ['g', 'h', 'i'],
    5: ['j', 'k', 'l'],
    6: ['m', 'n', 'o'],
    7: ['p', 'q', 'r', 's'],
    8: ['t', 'u', 'v'],
    9: ['w', 'x', 'y', 'z']
  };

  var combinations = [];

  function combine(combo, remaining) {
    if(!remaining.length) {
      return combinations.push(combo);  
    }
    combo = combo || '';
    var num = remaining[0];
    var letters = numsToLetters[num];
    if(num == 0 || num == 1) {
      combine(combo+num, remaining.slice(1));
    } else {
      for(var i=0; i<letters.length; i++) {
        var letter = letters[i];
        combine(combo+letter, remaining.slice(1));
      }
    }
  }

  combine('', digits);
  return combinations;
}

console.log(letterCombinations('123'));
