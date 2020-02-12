describe('Mortgage Calculator', function() {
  beforeAll(function() {
    // Ignorisemo sinhronizaciju sa Angularom jer testiramo sajt koji nije napisan u Angularu.
    // Ova linija se ne pise za prave Angular aplikacije.
    browser.ignoreSynchronization = true;
    // Odlazimo na sajt
    browser.get('http://www.calculator.net/mortgage-calculator.html');
    expect(browser.getCurrentUrl()).toEqual('http://www.calculator.net/mortgage-calculator.html');
  });
  
  it('should ensure that the checkbox is not checked.', function() {
    browser.sleep(4000);
    // Click on Checkbox Button
    var checkbox = element(by.id("caddoptional"));
    
    var finalSelectedState = checkbox.isSelected().then(function(isSelected) {
        // Klik na checkbox samo ako je vec selektovan
        if (isSelected) {
            checkbox.click();
        }
        
        return checkbox.isSelected();
    });
    
    expect(element(by.id("caddoptional")).isSelected()).toBe(false);
    
    browser.sleep(4000);
  });
});