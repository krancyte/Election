var validation = {
  checkMin :
  function checkMin(name, l) {
    if (name.length  >= l) {
      return true;
    } else {
      return false;
    }
  },
  checkMax :
  function checkMax(name, l) {
    if (name.length  <= l) {
      return true;
    } else {
      return false;
    }
  },
  checkSurname :
  function checkSurname(name) {
    var doubleSurnameRegex = new RegExp('^[A-Za-z]*-[A-Za-z]*$');
    var surnameRegex = new RegExp('^[A-Za-z]*$');
    var isMatchingDouble = doubleSurnameRegex.test(name);
    var isMatching = surnameRegex.test(name);
    if (isMatchingDouble || isMatching) {
      return true;
    } else {
      return false;
    }
  }
};

window.validation = validation;