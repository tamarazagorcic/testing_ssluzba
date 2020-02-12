var utils = require('../pages/utils.js');
var LoginPage = require('../pages/globalzavrsni/login.page.js');
var MenuPage = require('../pages/globalzavrsni/menu.page.js');
var ModalPage = require('../pages/globalzavrsni/modal.succes.page.js');
var InstitucijeOsnovniPage = require('../pages/institucijezavrsni/institucije.osnovni.js');
var InstitucijeProjektiPage = require('../pages/institucijezavrsni/institucije.projekti.js');
var InstitucijeRegistarPage = require('../pages/institucijezavrsni/institucije.registar.js');

var baseUrl = 'http://127.0.0.1:8080/#/login';


describe('testAll', function() {
    var loginPage,
        menuPage,
        modalPage,
        institucijeOsnovniPage,
        institucijeProjektiPage,
        institucijeRegistarPage;

    beforeAll(function() {
        loginPage = new LoginPage();
        menuPage = new MenuPage();
        modalPage = new ModalPage();
		institucijeOsnovniPage = new InstitucijeOsnovniPage();
		institucijeProjektiPage = new InstitucijeProjektiPage();
		institucijeRegistarPage = new InstitucijeRegistarPage();
        browser.get('/');

        // Login
        
        expect(loginPage.username.isDisplayed()).toBe(true);
        expect(loginPage.password.isDisplayed()).toBe(true);
        loginPage.login("djura@djuraminis.com", "adminvinca");
        expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/#/admin-institution/');
    });

    it('should change language on Serbian Latin',function(){
        menuPage.languages.click();
        menuPage.srpskiLatinica.click();
        
      });



      //testiranje osnovnih podataka institucije
    it('adding institution without name should display error message name is missig', function(){
        var drzava = ['Srbija'];
        var nadredjenaInstitucija = ['Fakultet tehničkih nauka'];
        institucijeOsnovniPage.unosOsnovnihPodataka("", "Biology Institute", drzava , "Novi Sad", "Novi Sad ",
        "neznana","bio.us.rs.un","biology@gmail.com","172183483476","biologijica",nadredjenaInstitucija);

     
        var errorMessage = institucijeOsnovniPage.nazivRequired;
        expect(errorMessage.isDisplayed()).toBe(true);
                
           });

    it('adding institution without english name will have to fail because this field is required', function(){
        var drzava = ['Srbija'];
        var nadredjenaInstitucija = ['Fakultet tehničkih nauka'];
        institucijeOsnovniPage.unosOsnovnihPodataka ("Institut Biologija", "", drzava, "Novi Sad", "Novi Sad ",
                    "neznana","bio.us.rs.un","biology@gmail.com","172183483476","biologijica", nadredjenaInstitucija);
     
        expect(modalPage.successSaveAlert.isDisplayed()).not.toBe(true);
        modalPage.closeSuccessBtn;
     //ne bi trebalo da sacuva podatke jer je polje naziva na engleskom obavezno polje, a sacuva ih
     //ovaj test pada
    
                
           });

    it('adding institution with other country', function(){
        var drzava = ['Dodaj novu...'];
        var nadredjenaInstitucija = ['Fakultet tehničkih nauka'];
        institucijeOsnovniPage.nazivInstitucije = 'Institut Biologija';
        institucijeOsnovniPage.nazivNaEngleskom = 'Biology Institute';
        institucijeOsnovniPage.drzava = drzava;
        institucijeOsnovniPage.noveDrzave('Burkina','Faso');
        institucijeOsnovniPage.nazivMesta = 'Novi Sad';
        institucijeOsnovniPage.nazivOpstine = 'Novi Sad';
        institucijeOsnovniPage.nazivUlice = 'neznana';
        institucijeOsnovniPage.webAdresa = 'bio.us.rs.un';
        institucijeOsnovniPage.email = 'biology@gmail.com';
        institucijeOsnovniPage.phone = '172183483476';
        institucijeOsnovniPage.skraceniNaziv = 'biologijica';
        institucijeOsnovniPage.nadredjenaInstitucija = nadredjenaInstitucija;
        institucijeOsnovniPage.saveButton.click();

         
        expect(modalPage.successSaveAlert.isDisplayed()).toBe(true);
        modalPage.closeSuccessBtn;
         
                    
               });


  // it('adding institution with right credentials is succesfull', function(){
   // var drzava = ['Srbija'];
   // var nadredjenaInstitucija = ['Fakultet tehničkih nauka'];
   //     institucijeOsnovniPage.unosOsnovnihPodataka ("Institut Biologija", "Biology Institute", drzava, "Novi Sad", "Novi Sad ",
   //                 "neznana","bio.us.rs.un","biology@gmail.com","172183483476","biologijica",nadredjenaInstitucija);
          
    //     expect(modalPage.successSaveAlert.isDisplayed()).toBe(true);
   //      modalPage.closeSuccessBtn;
   //        });


   it('adding inputs into the Register data with no credencials', function(){
    
    institucijeRegistarPage.tabPodaciZaRegistar.click();
    institucijeRegistarPage.pib = '';
    institucijeRegistarPage.maticniBroj = '';
    institucijeRegistarPage.brojAkreditacije = '';
    institucijeRegistarPage.datumAkreditacije = '';
    institucijeRegistarPage.institucijaAkreditacije = '';
    institucijeRegistarPage.napomenaoRegistru = '';
    institucijeRegistarPage.vrstaInstitucije = '';
    institucijeRegistarPage.osnivac = '';
    institucijeRegistarPage.datumOsnivanja = '';
    institucijeRegistarPage.brojResenjaOOsnivanju = '';
    institucijeRegistarPage.vlasnickaStruktura = '';
    institucijeRegistarPage.saveBtn.click();

    var errorMessagePib = institucijeRegistarPage.pibRequired;
    expect(errorMessagePib.isDisplayed()).toBe(true);
    var errorMessageMaticniBroj = institucijeRegistarPage.mbRequired;
    expect(errorMessageMaticniBroj.isDisplayed()).toBe(true);
    var errorMessageBrAkreditacije = institucijeRegistarPage.brAkreditacijeRequired;
    expect(errorMessageBrAkreditacije.isDisplayed()).toBe(true);
    var errorMessageDatumAkreditacije = institucijeRegistarPage.datumAkreditacijeRequired;
    expect(errorMessageDatumAkreditacije.isDisplayed()).toBe(true);
    var errorMessageNazivInstitucijeAkreditacije = institucijeRegistarPage.institucijaAkreditacijeRequired;
    expect(errorMessageNazivInstitucijeAkreditacije.isDisplayed()).toBe(true);
     });


    it('adding inputs into the Register data with no pib', function(){
        
        
        institucijeRegistarPage.pib = '';
        institucijeRegistarPage.maticniBroj = '15021988805055';
        institucijeRegistarPage.brojAkreditacije = '454';
        institucijeRegistarPage.datumAkreditacije = '15.02.2016';
        institucijeRegistarPage.institucijaAkreditacije = 'Institut Biologija';
        institucijeRegistarPage.napomenaoRegistru = 'nema napomene';
        institucijeRegistarPage.vrstaInstitucije = 'Univerzitet';
        institucijeRegistarPage.osnivac = 'drzava';
        institucijeRegistarPage.datumOsnivanja = '11.11.1999';
        institucijeRegistarPage.brojResenjaOOsnivanju = '43';
        institucijeRegistarPage.vlasnickaStruktura = 'Državna';
        institucijeRegistarPage.saveBtn.click();
    
        var errorMessagePib = institucijeRegistarPage.pibRequired;
        expect(errorMessagePib.isDisplayed()).toBe(true);
    });

    it('adding inputs into the Register data with wrong format pib', function(){
        
        
        institucijeRegistarPage.pib = 'a';
        institucijeRegistarPage.maticniBroj = '15021988805055';
        institucijeRegistarPage.brojAkreditacije = '454';
        institucijeRegistarPage.datumAkreditacije = '15.02.2016';
        institucijeRegistarPage.institucijaAkreditacije = 'Institut Biologija';
        institucijeRegistarPage.napomenaoRegistru = 'nema napomene';
        institucijeRegistarPage.vrstaInstitucije = 'Univerzitet';
        institucijeRegistarPage.osnivac = 'drzava';
        institucijeRegistarPage.datumOsnivanja = '11.11.1999';
        institucijeRegistarPage.brojResenjaOOsnivanju = '43';
        institucijeRegistarPage.vlasnickaStruktura = 'Državna';
        institucijeRegistarPage.saveBtn.click();
    
        var errorMessagePib = institucijeRegistarPage.pibFormatError;
        expect(errorMessagePib.isDisplayed()).toBe(true);
    });

    it('adding inputs into the Register data with no jmbg', function(){
            
            
            institucijeRegistarPage.pib = '1535251';
            institucijeRegistarPage.maticniBroj = '';
            institucijeRegistarPage.brojAkreditacije = '454';
            institucijeRegistarPage.datumAkreditacije = '15.02.2016';
            institucijeRegistarPage.institucijaAkreditacije = 'Institut Biologija';
            institucijeRegistarPage.napomenaoRegistru = 'nema napomene';
            institucijeRegistarPage.vrstaInstitucije = 'Univerzitet';
            institucijeRegistarPage.osnivac = 'drzava';
            institucijeRegistarPage.datumOsnivanja = '11.11.1999';
            institucijeRegistarPage.brojResenjaOOsnivanju = '43';
            institucijeRegistarPage.vlasnickaStruktura = 'Državna';
            institucijeRegistarPage.saveBtn.click();
        
            var errorMessageMaticniBroj = institucijeRegistarPage.mbRequired;
            expect(errorMessageMaticniBroj.isDisplayed()).toBe(true);
    });

    it('adding inputs into the Register data with wrong form of  12 caracters jmbg', function(){
        
        
        institucijeRegistarPage.pib = '1535251';
        institucijeRegistarPage.maticniBroj = '123456789123';
        institucijeRegistarPage.brojAkreditacije = '454';
        institucijeRegistarPage.datumAkreditacije = '15.02.2016';
        institucijeRegistarPage.institucijaAkreditacije = 'Institut Biologija';
        institucijeRegistarPage.napomenaoRegistru = 'nema napomene';
        institucijeRegistarPage.vrstaInstitucije = 'Univerzitet';
        institucijeRegistarPage.osnivac = 'drzava';
        institucijeRegistarPage.datumOsnivanja = '11.11.1999';
        institucijeRegistarPage.brojResenjaOOsnivanju = '43';
        institucijeRegistarPage.vlasnickaStruktura = 'Državna';
        institucijeRegistarPage.saveBtn.click();
    
        expect(modalPage.successSaveAlert.isDisplayed()).not.toBe(true);
        modalPage.closeSuccessBtn;
       
    });

    it('adding inputs into the Register data with wrong form of 14 caracters jmbg', function(){
        
        
        institucijeRegistarPage.pib = '1535251';
        institucijeRegistarPage.maticniBroj = '12345678912345';
        institucijeRegistarPage.brojAkreditacije = '454';
        institucijeRegistarPage.datumAkreditacije = '15.02.2016';
        institucijeRegistarPage.institucijaAkreditacije = 'Institut Biologija';
        institucijeRegistarPage.napomenaoRegistru = 'nema napomene';
        institucijeRegistarPage.vrstaInstitucije = 'Univerzitet';
        institucijeRegistarPage.osnivac = 'drzava';
        institucijeRegistarPage.datumOsnivanja = '11.11.1999';
        institucijeRegistarPage.brojResenjaOOsnivanju = '43';
        institucijeRegistarPage.vlasnickaStruktura = 'Državna';
        institucijeRegistarPage.saveBtn.click();
    
        expect(modalPage.successSaveAlert.isDisplayed()).not.toBe(true);
        modalPage.closeSuccessBtn;
       
    });

    it('adding inputs into the Register data with wrong form letters jmbg', function(){
        
        
        institucijeRegistarPage.pib = '1535251';
        institucijeRegistarPage.maticniBroj = 'ana';
        institucijeRegistarPage.brojAkreditacije = '454';
        institucijeRegistarPage.datumAkreditacije = '15.02.2016';
        institucijeRegistarPage.institucijaAkreditacije = 'Institut Biologija';
        institucijeRegistarPage.napomenaoRegistru = 'nema napomene';
        institucijeRegistarPage.vrstaInstitucije = 'Univerzitet';
        institucijeRegistarPage.osnivac = 'drzava';
        institucijeRegistarPage.datumOsnivanja = '11.11.1999';
        institucijeRegistarPage.brojResenjaOOsnivanju = '43';
        institucijeRegistarPage.vlasnickaStruktura = 'Državna';
        institucijeRegistarPage.saveBtn.click();
    
        
        var errorMessageMaticniBroj = institucijeRegistarPage.mbFormatError;
        expect(errorMessageMaticniBroj.isDisplayed()).toBe(true);
    });

    it('adding inputs into the Register data with no number of acreditation', function(){
        
        
        institucijeRegistarPage.pib = '1535251';
        institucijeRegistarPage.maticniBroj = '15021988805055';
        institucijeRegistarPage.brojAkreditacije = '';
        institucijeRegistarPage.datumAkreditacije = '15.02.2016';
        institucijeRegistarPage.institucijaAkreditacije = 'Institut Biologija';
        institucijeRegistarPage.napomenaoRegistru = 'nema napomene';
        institucijeRegistarPage.vrstaInstitucije = 'Univerzitet';
        institucijeRegistarPage.osnivac = 'drzava';
        institucijeRegistarPage.datumOsnivanja = '11.11.1999';
        institucijeRegistarPage.brojResenjaOOsnivanju = '43';
        institucijeRegistarPage.vlasnickaStruktura = 'Državna';
        institucijeRegistarPage.saveBtn.click();
    
        var errorMessageBrAkreditacije = institucijeRegistarPage.brAkreditacijeRequired;
        expect(errorMessageBrAkreditacije.isDisplayed()).toBe(true);
    });

    it('adding inputs into the Register data with no date of acreditation', function(){
        
        
        institucijeRegistarPage.pib = '1535251';
        institucijeRegistarPage.maticniBroj = '15021988805055';
        institucijeRegistarPage.brojAkreditacije = '454';
        institucijeRegistarPage.datumAkreditacije = '';
        institucijeRegistarPage.institucijaAkreditacije = 'Institut Biologija';
        institucijeRegistarPage.napomenaoRegistru = 'nema napomene';
        institucijeRegistarPage.vrstaInstitucije = 'Univerzitet';
        institucijeRegistarPage.osnivac = 'drzava';
        institucijeRegistarPage.datumOsnivanja = '11.11.1999';
        institucijeRegistarPage.brojResenjaOOsnivanju = '43';
        institucijeRegistarPage.vlasnickaStruktura = 'Državna';
        institucijeRegistarPage.saveBtn.click();
    
        var errorMessageDatumAkreditacije = institucijeRegistarPage.datumAkreditacijeRequired;
        expect(errorMessageDatumAkreditacije.isDisplayed()).toBe(true);
    });

    it('adding inputs into the Register data with wrong number of days date of acreditation', function(){
        
        
        institucijeRegistarPage.pib = '1535251';
        institucijeRegistarPage.maticniBroj = '15021988805055';
        institucijeRegistarPage.brojAkreditacije = '454';
        institucijeRegistarPage.datumAkreditacije = '32.02.2016';
        institucijeRegistarPage.institucijaAkreditacije = 'Institut Biologija';
        institucijeRegistarPage.napomenaoRegistru = 'nema napomene';
        institucijeRegistarPage.vrstaInstitucije = 'Univerzitet';
        institucijeRegistarPage.osnivac = 'drzava';
        institucijeRegistarPage.datumOsnivanja = '11.11.1999';
        institucijeRegistarPage.brojResenjaOOsnivanju = '43';
        institucijeRegistarPage.vlasnickaStruktura = 'Državna';
        institucijeRegistarPage.saveBtn.click();
    
        var errorMessageDatumAkreditacije = institucijeRegistarPage.datumAkreditacijeRequired;
        expect(errorMessageDatumAkreditacije.isDisplayed()).toBe(true);
    });

    it('adding inputs into the Register data with wrong number of months date of acreditation', function(){
        
        
        institucijeRegistarPage.pib = '1535251';
        institucijeRegistarPage.maticniBroj = '15021988805055';
        institucijeRegistarPage.brojAkreditacije = '454';
        institucijeRegistarPage.datumAkreditacije = '15.13.2016';
        institucijeRegistarPage.institucijaAkreditacije = 'Institut Biologija';
        institucijeRegistarPage.napomenaoRegistru = 'nema napomene';
        institucijeRegistarPage.vrstaInstitucije = 'Univerzitet';
        institucijeRegistarPage.osnivac = 'drzava';
        institucijeRegistarPage.datumOsnivanja = '11.11.1999';
        institucijeRegistarPage.brojResenjaOOsnivanju = '43';
        institucijeRegistarPage.vlasnickaStruktura = 'Državna';
        institucijeRegistarPage.saveBtn.click();
    
        var errorMessageDatumAkreditacije = institucijeRegistarPage.datumAkreditacijeRequired;
        expect(errorMessageDatumAkreditacije.isDisplayed()).toBe(true);
    });


//test sa datumom u buducnosti ne bi trebao da prolazi jer je u pitanju datum poslednje naucne akreditacije sto je nemoguce u buducnosti!!!!

it('adding inputs into the Register data with future date of acreditation', function(){
    
    
    institucijeRegistarPage.pib = '1535251';
    institucijeRegistarPage.maticniBroj = '15021988805055';
    institucijeRegistarPage.brojAkreditacije = '454';
    institucijeRegistarPage.datumAkreditacije = '15.02.2018';
    institucijeRegistarPage.institucijaAkreditacije = 'Institut Biologija';
    institucijeRegistarPage.napomenaoRegistru = 'nema napomene';
    institucijeRegistarPage.vrstaInstitucije = 'Univerzitet';
    institucijeRegistarPage.osnivac = 'drzava';
    institucijeRegistarPage.datumOsnivanja = '11.11.1999';
    institucijeRegistarPage.brojResenjaOOsnivanju = '43';
    institucijeRegistarPage.vlasnickaStruktura = 'Državna';
    institucijeRegistarPage.saveBtn.click();

    expect(modalPage.successSaveAlert.isDisplayed()).not.toBe(true);
    modalPage.closeSuccessBtn;
 //ne bi trebalo da sacuva podatke jer je datum u buducnosti a sacuva ih
 //ovaj test pada
});

it('adding inputs into the Register data with no nameof institution of acreditation', function(){
    
    
    institucijeRegistarPage.pib = '1535251';
    institucijeRegistarPage.maticniBroj = '15021988805055';
    institucijeRegistarPage.brojAkreditacije = '454';
    institucijeRegistarPage.datumAkreditacije = '15.02.2016';
    institucijeRegistarPage.institucijaAkreditacije = '';
    institucijeRegistarPage.napomenaoRegistru = 'nema napomene';
    institucijeRegistarPage.vrstaInstitucije = 'Univerzitet';
    institucijeRegistarPage.osnivac = 'drzava';
    institucijeRegistarPage.datumOsnivanja = '11.11.1999';
    institucijeRegistarPage.brojResenjaOOsnivanju = '43';
    institucijeRegistarPage.vlasnickaStruktura = 'Državna';
    institucijeRegistarPage.saveBtn.click();

    var errorMessageNazivInstitucijeAkreditacije = institucijeRegistarPage.institucijaAkreditacijeRequired;
    expect(errorMessageNazivInstitucijeAkreditacije.isDisplayed()).toBe(true);
});




it('adding inputs into the Register data with right credencials ', function(){
         
    institucijeRegistarPage.unosPodatakaZaRegistar ("1535251", "15021988805055", "454", "15.02.2016", "Institut Biologija", "nema napomene", "Univerzitet", "drzava",
    "11.11.1999", "43", "Državna");

    
    expect(modalPage.successSaveAlert.isDisplayed()).toBe(true);
    modalPage.closeSuccessBtn;
        
    
      
});
     
     
it('Checking is pattern for account field corect ', function(){
           
    institucijeProjektiPage.tabPodaciZaProjekte.click();

    var racun=institucijeProjektiPage.racun;
            racun.clear();
            racun.sendKeys ("11-111111112111415-1");
                expect(institucijeProjektiPage.racunFormatError.isDisplayed()).toBe(true);
            racun.clear();
            racun.sendKeys("1-111111121511415-11");
                expect(institucijeProjektiPage.racunFormatError.isDisplayed()).toBe(true);
            racun.clear();
            racun.sendKeys("11-1111111211415-111");
                expect(institucijeProjektiPage.racunFormatError.isDisplayed()).toBe(true);
            racun.clear();
            racun.sendKeys("11-1111111211141-15");
                expect(institucijeProjektiPage.racunFormatError.isDisplayed()).toBe(true);
            racun.clear();
            racun.sendKeys("11-111111121114155-15");
                expect(institucijeProjektiPage.racunFormatError.isDisplayed()).toBe(true);
            racun.clear();
            racun.sendKeys("11-11111112111415-1s");
                expect(institucijeProjektiPage.racunFormatError.isDisplayed()).toBe(true);
            racun.clear();
            racun.sendKeys("1111-1111112111415-11");
                expect(institucijeProjektiPage.racunFormatError.isDisplayed()).toBe(true);
            racun.clear();
            racun.sendKeys("11-11111112111415-1%");
                expect(institucijeProjektiPage.racunFormatError.isDisplayed()).toBe(true);
            racun.clear();
            racun.sendKeys("11-11111112111415- 1");
                expect(institucijeProjektiPage.racunFormatError.isDisplayed()).toBe(true);
            racun.clear();
            racun.sendKeys("111111111211141515");
                expect(institucijeProjektiPage.racunFormatError.isDisplayed()).toBe(true);
 
});
         
it('Should not accept saving project data without entering any input ', function(){
    institucijeProjektiPage.unosPodatakaZaProjekte ("","","");
             
               expect(institucijeProjektiPage.racuRequired.isDisplayed()).toBe(true);
              // expect(institucijeProjektiPage.statusRequred.isDisplayed()).toBe(true);

});
it('Should not accept saving project data without account field ', function(){
    institucijeProjektiPage.racun = '';
    institucijeProjektiPage.medjbrojMinistarstva = '45365135';
    institucijeProjektiPage.statusInstitucije = 'Aktivan';

             
               expect(institucijeProjektiPage.racuRequired.isDisplayed()).toBe(true);
               

});



it('Should accept saving project data with entering right credencials ', function(){
    institucijeProjektiPage.unosPodatakaZaProjekte ("123-1234567891234-22","45365135","Aktivan");
              
              expect(modalPage.successSaveAlert.isDisplayed()).toBe(true);
               modalPage.closeSuccessBtn;

});







    afterAll(function() {
        menuPage.dropdownmenu.click();
		menuPage.logoutBtn.click();
    });
});



it('should add istrazivac',function(){
    menuPage.istrazivaciBtn.click();
    expect(istrazivaciMainPage.pretragaIstrazivaca.isDisplayed()).toBe(true);
    istrazivaciLicniPodaciPage.dodajIstrazivacaBtn.click();

    istrazivaciLicniPodaciPage.ime = 'Djordje';
    istrazivaciLicniPodaciPage.prezime = 'Rajkovic';
    istrazivaciLicniPodaciPage.imeRoditelja = 'Tanja';
    istrazivaciLicniPodaciPage.titulaIstrazivaca = 'Mr';
    istrazivaciLicniPodaciPage.datumRodjenja = '12.08.1987';
    istrazivaciLicniPodaciPage.drzavaRodjenja = 'Kraljevo';
    istrazivaciLicniPodaciPage.gradRodjenja = 'Novi Sad';
    istrazivaciLicniPodaciPage.opstinaRodjenja = 'Novi Sad';
    istrazivaciLicniPodaciPage.drzavaPrebivalista = 'Norveska';
    istrazivaciLicniPodaciPage.mestoPrebivalista = 'Ne znam';
    istrazivaciLicniPodaciPage.opstinaPrebivalista = 'Ne znam';
    istrazivaciLicniPodaciPage.adresa = 'neznaman';
    istrazivaciLicniPodaciPage. pol = 'Muški';
    istrazivaciLicniPodaciPage.jmbg = '1446566555165';
    istrazivaciLicniPodaciPage.email = 'hajdahsdb@jakdf';
    istrazivaciLicniPodaciPage.telefon = '5435438543'
    istrazivaciLicniPodaciPage.webAdresa = 'DF.sksL.s';
    istrazivaciLicniPodaciPage.statusIstrazivaca = '';

    
    istrazivaciLicniPodaciPage.saveBtn.click();

    expect(modalPage.successSaveAlert.isDisplayed()).toBe(true);
    modalPage.closeSuccessBtn;

 });