function isValid(rows, possibleCol) {
  var rowNum = rows.length;

  for(var i=0;i<rows.length; i++) {
    var colPos = rows[i];
    var isInSameColumn = colPos === possibleCol;
    var isDiagonalRight = colPos+(rowNum-i) === possibleCol;
    var isDiagonalLeft = colPos-(rowNum-i) === possibleCol;

    if(isInSameColumn || isDiagonalLeft || isDiagonalRight) {
      return false;
    }
  }
  return true;
}

function nQueens(n) {
  var validTables = [];

  function rec(currentRows) {
    if(currentRows.length === n) {
      validTables.push(currentRows);
      return;
    }
    for(var j=0; j<n; j++) {
      if(isValid(currentRows, j)) {
        rec(currentRows.concat([j]));
      }
    }
  }

  rec([]);

  return validTables;
}

console.log(nQueens(5))
