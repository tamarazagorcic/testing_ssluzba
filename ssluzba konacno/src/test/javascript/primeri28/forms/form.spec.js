describe('Form validation page', function() {
    
  function get201Characters(){
    var output = '';
    for (var i = 0; i < 201; i++){
        output += 'a';
    }
    return output;
  }
    
  beforeAll(function() {
    browser.ignoreSynchronization = true;
    // Odlazimo na sajt
    browser.get('http://formvalidation.io/examples/complex-form/');
    
    //TODO : postaviti explicitno cekanje na promenu url-a.
    
    expect(browser.getCurrentUrl()).toEqual('http://formvalidation.io/examples/complex-form/');
  });
  
  it('should have all the form elements displayed', function() {
		var EC = protractor.ExpectedConditions;
        
    var iFrame = element(by.id('demo-frame'));
    browser.switchTo().frame(iFrame.getWebElement());
    browser.ignoreSynchronization = true;
    var form = element(by.id('movieForm'));
    // Cekanje na vidljivost elementa movieForm
    browser.wait(EC.visibilityOf(form), 5000, 'Form was never present on page.');
    // Cekanje na mogucnost klika na dugme za validaciju
    var validateBtn = form.element(by.buttonText('Validate'));
    browser.wait(EC.elementToBeClickable(validateBtn), 5000, 'Validation button cannot be clicked.');
    
	  expect(form.isDisplayed()).toBe(true);
    
    // TODO : validirati postojanje svih elemenata forme
  });
  
  describe('movie title', function() {
    it('should have the correct error for empty title input.', function() {
      var form = element(by.id('movieForm'));
      var validateBtn = form.element(by.buttonText('Validate'));
      validateBtn.click();
      
      var errors = form.all(by.xpath('//input[@name=\"title\"]/following-sibling::small'));
      expect(errors.get(0).getText()).toEqual('The title is required');
      expect(errors.get(1).isDisplayed()).toBe(false);
      expect(validateBtn.isEnabled()).toBe(false);
    });
    
    it('should have the correct error for too many characters.', function() {
      var form = element(by.id('movieForm'));
      var validateBtn = form.element(by.buttonText('Validate'));
      var movieTitle = form.element(by.name('title'));
      
      movieTitle.clear().sendKeys(get201Characters());
      
      var errors = form.all(by.xpath('//input[@name=\"title\"]/following-sibling::small'));
      expect(errors.get(0).isDisplayed()).toBe(false);
      expect(errors.get(1).isDisplayed()).toBe(true);
      expect(errors.get(1).getText()).toEqual('The title must be less than 200 characters long');
      expect(validateBtn.isEnabled()).toBe(false);
    });
  });
  
});