describe('Mortgage Payoff Calculator', function() {
  beforeAll(function() {
    // Ignorisemo sinhronizaciju sa Angularom jer testiramo sajt koji nije napisan u Angularu.
    // Ova linija se ne pise za prave Angular aplikacije.
    browser.ignoreSynchronization = true;
    // Odlazimo na sajt
    browser.get('http://www.calculator.net/mortgage-payoff-calculator.html');
    expect(browser.getCurrentUrl()).toEqual('http://www.calculator.net/mortgage-payoff-calculator.html');
  });
  
  it('should check a radio button.', function() {
    browser.sleep(4000);
      
    // Click on Radio Button
    element(by.id("cpayoff1")).click();
    expect(element(by.id("cpayoff1")).isSelected()).toBe(true);
    expect(element(by.id("cpayoff1")).isEnabled()).toBe(true);
    expect(element(by.id("cpayoff1")).isPresent()).toBe(true);
    expect(element(by.id("cpayoff1")).isDisplayed()).toBe(true);
    
    browser.sleep(4000);
  });
});