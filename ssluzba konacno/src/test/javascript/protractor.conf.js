var Jasmine2HtmlReporter = require('protractor-jasmine2-html-reporter');
var SpecReporter = require('jasmine-spec-reporter');

exports.config = {
    seleniumServerJar: '../../../node_modules/protractor/selenium/selenium-server-standalone-2.47.1.jar',
    chromeDriver: '../../../node_modules/protractor/selenium/chromedriver',
    allScriptsTimeout: 60000,

    specs: [
       // 'e2e/specs/zadatak1.spec.js',
       // 'e2e/specs/zadatak2.spec.js',
      //  'e2e/specs/zadatak3.spec.js',
       // 'e2e/specs/vezba.spec.js',
        //'e2e/specs/vezba2.spec.js',
        //'e2e/specs/login.spec.js',
        'e2e/specs/zavrsniIspit.spec.js',
        'e2e/specs/zavrsniIspit2.spec.js',
        

    ],

    capabilities: {
        'browserName': 'chrome',
    },

    directConnect: true,

    baseUrl: 'http://localhost:8080/',

    framework: 'jasmine2',

    jasmineNodeOpts: {
        showColors: true,
        isVerbose: true,
        defaultTimeoutInterval: 60000,
        print: function() {}
    },

    onPrepare: function() {
        // Postavljamo prozor na fullscreen
        browser.driver.manage().window().maximize();
        
        // Registrujemo reportere
        jasmine.getEnv().addReporter(new Jasmine2HtmlReporter({
            savePath: "./target/reports/e2e/",
            takeScreenshots: true,
            takeScreenshotsOnlyOnFailures: true,
            fixedScreenshotName: true
        }));
        jasmine.getEnv().addReporter(new SpecReporter({
            displayStacktrace: 'all',
            displaySpecDuration: true, 
            displayFailuresSummary: false, 
            displayPendingSummary: false,  
        }));
    }
};
