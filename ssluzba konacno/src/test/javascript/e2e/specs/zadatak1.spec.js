var LoginPage = require('../pages/global/login.page.js');
var MenuPage = require('../pages/global/menu.page.js');
var StudentsListPage = require('../pages/studenti/students-list.page.js');
var StudentsCreationPage = require('../pages/studenti/students-creation.page.js');
var ModalDeletePage = require('../pages/global/modal-delete.page.js');
var utils = require('../pages/utils.js');
var baseUrl = 'http://localhost:8080/#/';

describe('zadatak1', function() {
    var loginPage,
        menuPage,
        studentsListPage,
        studentsCreationPage,
        modalDeletePage;

    beforeAll(function() {
        loginPage = new LoginPage();
		menuPage = new MenuPage();
		studentsListPage = new StudentsListPage();
		studentsCreationPage = new StudentsCreationPage();
		modalDeletePage = new ModalDeletePage();
        browser.get('/');

        // Login
        menuPage.accountMenu.click();
		expect(menuPage.signUp.isDisplayed()).toBe(true);
		menuPage.signUp.click();
		loginPage.login("admin", "admin");
    });

    it('should add the first student.', function() {
        menuPage.entities.click();
        expect(menuPage.studentsLink.isDisplayed()).toBe(true);
		menuPage.studentsLink.click();

		// verify students list page
		utils.waitForTitle("Studentis", 10000);
        expect(browser.getCurrentUrl()).toEqual(baseUrl + 'studentis');
        expect(studentsListPage.studentsTable.isDisplayed()).toBe(true);
		var createBtn = studentsListPage.createBtn;
		expect(createBtn.isDisplayed()).toBe(true);
		createBtn.click();

		// verify is modal present
		expect(browser.getCurrentUrl()).toEqual(baseUrl + 'studentis/new');
        expect(studentsCreationPage.modalDialog.isDisplayed()).toBe(true);
		// check visibility
		expect(studentsCreationPage.index.isDisplayed()).toBe(true);
		expect(studentsCreationPage.ime.isDisplayed()).toBe(true);
		expect(studentsCreationPage.prezime.isDisplayed()).toBe(true);
		expect(studentsCreationPage.grad.isDisplayed()).toBe(true);
		expect(studentsCreationPage.cancelBtn.isDisplayed()).toBe(true);
		expect(studentsCreationPage.saveBtn.isDisplayed()).toBe(true);

		studentsCreationPage.createStudent("E1234", "Marko", "Markovic", "Novi Sad");
		// add new student via helper function
		createBtn = studentsListPage.createBtn;
		expect(createBtn.isDisplayed()).toBe(true);
		createBtn.click();

		// check row data
		expect(studentsListPage.studentsTable.isDisplayed()).toBe(true);
		var studentRow = studentsListPage.getStudentRowByIndex("E1234");
		expect(studentRow.rowElement.isPresent()).toBe(true);
		expect(studentRow.rowElement.getText()).toContain("E1234 Marko Markovic Novi Sad");

        // ili bolja provera u ovom slucaju

        expect(studentRow.index).toEqual('E1234');
        expect(studentRow.ime).toEqual('Marko');
        expect(studentRow.prezime).toEqual('Markovic');
        expect(studentRow.grad).toEqual('Novi Sad');
    });

    it('should add the second student.', function() {
        // create a new student and check table content
		studentsCreationPage.createStudent("E5652", "Nikola", "Nikolic", "Beograda");
        var studentRow = studentsListPage.getStudentRowByIndex("E5652");
		expect(studentRow.rowElement.isPresent()).toBe(true);
        expect(studentRow.index).toEqual('E5652');
        expect(studentRow.ime).toEqual('Nikola');
        expect(studentRow.prezime).toEqual('Nikolic');
        expect(studentRow.grad).toEqual('Beograda');

		// edit Nikola Nikolic
		studentRow.editBtn.click();
		expect(studentsCreationPage.modalDialog.isDisplayed()).toBe(true);
		studentsCreationPage.grad = 'Kraljevo';
		studentsCreationPage.saveBtn.click();
		studentRow = studentsListPage.getStudentRowByIndex("E5652");
		expect(studentRow.rowElement.isPresent()).toBe(true);
        expect(studentRow.index).toEqual('E5652');
        expect(studentRow.ime).toEqual('Nikola');
        expect(studentRow.prezime).toEqual('Nikolic');
        expect(studentRow.grad).toEqual('Kraljevo');
    });

    it('should delete all students.', function() {
        // delete all added students
        var studentRow = studentsListPage.getStudentRowByIndex("E5652");
        studentRow.deleteBtn.click();
        modalDelete = modalDeletePage.modal;
        expect(modalDelete.isDisplayed()).toBe(true);
        modalDeletePage.confirmDelete();

        studentRow = studentsListPage.getStudentRowByIndex("E1234");
        expect(studentRow.rowElement.isPresent()).toBe(true);
        studentRow.deleteBtn.click();
        modalDelete = modalDeletePage.modal;
        expect(modalDelete.isDisplayed()).toBe(true);
        modalDeletePage.confirmDelete();

        // check table content
        expect(studentsListPage.getStudentRowByIndex("E1234").rowElement.isPresent()).toBe(false);
        expect(studentsListPage.getStudentRowByIndex("E5652").rowElement.isPresent()).toBe(false);
    });

    afterAll(function() {
        menuPage.accountMenu.click();
		menuPage.logOut.click();
    });
});