function combine(a, b) {
  var ans = [];
  var n = [];

  function findPerm(perm, remain) {
    if(perm.length === b) {
      return ans.push(perm);
    }
    for(var i=0; i<remain.length; i++) {
      var copy = remain.slice();
      var add = copy.splice(i, 1);
      if(add[0] < perm[perm.length-1]) {
        continue;
      }
      findPerm(perm.concat(add), copy);
    }
    if(perm.length === 1) {
      findPerm(remain.splice(0, 1), remain);
    }
  }

  if(b > a) {
    return [];
  }
  if(a === 1) {
    return [[1]];
  }
  if(b === 1) {
    for(var i=1; i<=a; i++) {
      ans.push([i]);
    }
  } else {
    for(var i=1; i<=a; i++) {
      n.push(i);
    }
    findPerm([1], n.slice(1));
  }

  return ans;
}

console.log(combine(4,2 ));
