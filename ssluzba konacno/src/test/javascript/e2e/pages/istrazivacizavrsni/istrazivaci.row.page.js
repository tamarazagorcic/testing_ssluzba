var IstrazivaciRow = function(rowElement) {
    this.rowElement = rowElement;
  }
  
  IstrazivaciRow.prototype = Object.create({}, {
    
   
    
    ime: {
      get: function() {
        return this.rowElement.element(by.binding('Ime')).getText();
      }
    },
    
    prezime: {
      get: function() {
        return this.rowElement.element(by.binding('Prezime')).getText();
      }
    },
    
    datumRodjenja: {
      get: function() {
        return this.rowElement.element(by.binding('Datum rođenja')).getText();
      }
    }
    
   
  });
  
  module.exports = IstrazivaciRow;
  