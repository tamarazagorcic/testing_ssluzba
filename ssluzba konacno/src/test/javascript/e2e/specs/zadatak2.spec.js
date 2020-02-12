var LoginPage = require('../pages/global/login.page.js');
var MenuPage = require('../pages/global/menu.page.js');
var StudentsListPage = require('../pages/studenti/students-list.page.js');
var StudentsCreationPage = require('../pages/studenti/students-creation.page.js');
var NastavniciListPage = require('../pages/nastavnici/nastavnici-list.page.js');
var NastavniciCreationPage = require('../pages/nastavnici/nastavnici-creation.page.js');
var PredmetiListPage = require('../pages/predmeti/predmeti-list.page.js');
var PredmetiCreationPage = require('../pages/predmeti/predmeti-creation.page.js');

var utils = require('../pages/utils.js');
var baseUrl = 'http://localhost:8080/#/';

describe('zadatak2', function() {
    var loginPage,
        menuPage,
        studentsListPage,
        studentsCreationPage,
        nastavniciListPage,
        nastavniciCreationPage,
        predmetiListPage,
        predmetiCreationPage

    beforeAll(function() {
        loginPage = new LoginPage();
		menuPage = new MenuPage();
		studentsListPage = new StudentsListPage();
		studentsCreationPage = new StudentsCreationPage();
		nastavniciListPage = new NastavniciListPage();
		nastavniciCreationPage = new NastavniciCreationPage();
		predmetiCreationPage = new PredmetiCreationPage();
		predmetiListPage = new PredmetiListPage();
        browser.get('/');

        // Login
        menuPage.accountMenu.click();
		expect(menuPage.signUp.isDisplayed()).toBe(true);
		menuPage.signUp.click();
		loginPage.login("admin", "admin");
    });

	// sve provere su ubacene u jedan test
	// TODO za vezbu razdvojiti ovaj test u manje celine
	it('should create students, professors and courses.', function() {
		// menu manipulation
		menuPage.entities.click();
		expect(menuPage.nastavniciLink.isDisplayed()).toBe(true);
		menuPage.nastavniciLink.click();

		utils.waitForTitle("Nastavnicis", 10000);
		nastavniciListPage.createBtn.click();
		nastavniciCreationPage.createNastavnik("Milan", "Markovic", "Profesor");
		expect(nastavniciListPage.nastavniciTable.isDisplayed()).toBe(true);
        var nastavnikRow = nastavniciListPage.getNastavnikByName('Milan');
		expect(nastavnikRow.rowElement.isPresent()).toBe(true);

		// menu manipulation
		menuPage.entities.click();
		expect(menuPage.studentsLink.isDisplayed()).toBe(true);
		menuPage.studentsLink.click();

		// verify students list page
		utils.waitForTitle("Studentis", 10000);
		expect(studentsListPage.studentsTable.isDisplayed()).toBe(true);
		var createBtn = studentsListPage.createBtn;
		expect(createBtn.isDisplayed()).toBe(true);
		createBtn.click();

		// verify is modal present
		expect(studentsCreationPage.modalDialog.isDisplayed()).toBe(true);
		expect(studentsCreationPage.modalDialogTitle.getText()).toEqual("Create or edit a Studenti");

		studentsCreationPage.createStudent("E1234", "Marko", "Markovic", "Novi Sad");
		// add new student via helper function
		createBtn = studentsListPage.createBtn;
		expect(createBtn.isDisplayed()).toBe(true);
		createBtn.click();

		// check row data
		expect(studentsListPage.studentsTable.isDisplayed()).toBe(true);
		var studentRow = studentsListPage.getStudentRowByIndex("E1234");
		expect(studentRow.rowElement.isPresent()).toBe(true);
		expect(studentRow.index).toEqual('E1234');
        expect(studentRow.ime).toEqual('Marko');
        expect(studentRow.prezime).toEqual('Markovic');
        expect(studentRow.grad).toEqual('Novi Sad');

		// create a new student and check table content
		studentsCreationPage.createStudent("E5652", "Nikola", "Nikolic", "Beograda");
		studentRow = studentsListPage.getStudentRowByIndex("E5652");
		expect(studentRow.rowElement.isPresent()).toBe(true);
        expect(studentRow.index).toEqual('E5652');
        expect(studentRow.ime).toEqual('Nikola');
        expect(studentRow.prezime).toEqual('Nikolic');
        expect(studentRow.grad).toEqual('Beograda');

		// menu manipulation
		menuPage.entities.click();
		expect(menuPage.predmetiLink.isDisplayed()).toBe(true);
		menuPage.predmetiLink.click();

		utils.waitForTitle("Predmetis", 10000);
		predmetiListPage.createBtn.click();
        var studenti = ['Marko Markovic', 'Nikola Nikolic'];

        var nastavnici = ['Milan Markovic'];
		predmetiCreationPage.createPredmet("Matematika", studenti, nastavnici);

        var predmet = predmetiListPage.getPredmetByName('Matematika');
        expect(predmet.rowElement.isPresent()).toBe(true);
        expect(predmet.ime).toEqual('Matematika');
        expect(predmet.studenti).toEqual('Marko Markovic, Nikola Nikolic');
        expect(predmet.nastavnici).toEqual('Milan Markovic');
    });

    afterAll(function() {
        menuPage.accountMenu.click();
		menuPage.logOut.click();
    });
});