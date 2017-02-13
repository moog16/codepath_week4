function permutations(arr) {
  var collections = [];

  function collectPerms(current, remain) {
    if(!remain.length) {
      return collections.push(current);
    }
    for(var i=0; i<remain.length; i++) {
      var _remain = remain.slice();
      var num = _remain[i];
      _remain.splice(i, 1);

      if(current && current.length) {
        collectPerms(current.concat([num]), _remain);
      } else {
        collectPerms([num], _remain);
      }

    }
  }

  collectPerms(null, arr);
  return collections;
}

console.log(permutations([1,2,3]))
