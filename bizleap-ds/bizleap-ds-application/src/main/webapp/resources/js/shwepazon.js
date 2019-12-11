
var active = "";

function loadAction(currentElement, activeId) {
	
	var request = new XMLHttpRequest;
	active = activeId;

	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		
		document.getElementById("content").innerHTML = request.responseText;
		
	    if(active == "departments") {
	    	loadDepartment();
			document.getElementById("department-content").className = "show";
		}
		else if(active == "majors") {
			loadMajor();
			document.getElementById("major-content").className = "show";
		}
		else if(active == "teachers") {
			loadTeacher();
			document.getElementById("teacher-content").className = "show";
		}
		else if(active == "staffs") {
			loadStaff();
			document.getElementById("staff-content").className = "show";
		}
		else if(active == "students") {
			loadStudent();
			document.getElementById("student-content").className = "show";
		}	
	}
		request.open("GET", active + "/list", true);
	
	request.send();
}

function loadDepartment() {
	var content = document.getElementById("content");
	content.innerHTML = "";
	var request = new XMLHttpRequest;

	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		
		var departmentJSON = JSON.parse(request.responseText);
		departmentJSON.forEach(data => {
			var department = document.createElement("div");
			department.setAttribute("id",data.boId);
			department.setAttribute("onclick","getDetail(this,'DEPARTMENT');");
			var br = document.createElement("br");
			var name = document.createElement("span");
			var boId = document.createElement("span");
			name.innerHTML = data.name;
			boId.innerHTML = data.boId;
			department.append(name);
			department.append(br);
			department.append(boId);
			department.style.margin='20px';
			content.append(department);
			document.getElementById("detail-table").className = "hide";

		});

// document.getElementById("department-content").onmouseover = function(){
// this.style.background = "grey";
// }

	}
	request.open("GET", "departments/list", true);
	request.send();
}


function loadTeacher() {
	var content = document.getElementById("content");
	content.innerHTML = "";
	var request = new XMLHttpRequest;

	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		
		var teacherJSON = JSON.parse(request.responseText);
		teacherJSON.forEach(data => {
			var teacher = document.createElement("div");
			teacher.setAttribute("id",data.boId);
			teacher.setAttribute("onclick","getDetail(this,'TEACHER');");
			var br = document.createElement("br");
			var name = document.createElement("span");
			var boId = document.createElement("span");
			name.innerHTML = data.name;
			boId.innerHTML = data.boId;
			teacher.append(name);
			teacher.append(br);
			teacher.append(boId);
			teacher.style.margin='20px';
			content.append(teacher);
			document.getElementById("detail-table").className = "hide";

		});

// document.getElementById("teacher-content").onmouseover = function(){
// this.style.background = "grey";
// }

	}
	request.open("GET", "teachers/list", true);
	request.send();
}


function loadStaff() {
	var content = document.getElementById("content");
	content.innerHTML = "";
	var request = new XMLHttpRequest;

	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		
		var staffJSON = JSON.parse(request.responseText);
		staffJSON.forEach(data => {
			var staff = document.createElement("div");
			staff.setAttribute("id",data.boId);
			staff.setAttribute("onclick","getDetail(this,'STAFF');");
			var br = document.createElement("br");
			var name = document.createElement("span");
			var boId = document.createElement("span");
			name.innerHTML = data.name;
			boId.innerHTML = data.boId;
			staff.append(name);
			staff.append(br);
			staff.append(boId);
			staff.style.margin='20px';
			content.append(staff);
			document.getElementById("detail-table").className = "hide";

		});

// document.getElementById("ataff-content").onmouseover = function(){
// this.style.background = "grey";
// }

	}
	request.open("GET", "staffs/list", true);
	request.send();
}


function loadMajor() {
	var content = document.getElementById("content");
	content.innerHTML = "";
	var request = new XMLHttpRequest;
	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		
		var majorJSON = JSON.parse(request.responseText);
		majorJSON.forEach(data => {
			var major = document.createElement("div");
			major.setAttribute("id",data.boId);
			major.setAttribute("onclick","getDetail(this,'MAJOR');");
			var br = document.createElement("br");
			var name = document.createElement("span");
			var boId = document.createElement("span");
			name.innerHTML = data.name;
			boId.innerHTML = data.boId;
			major.append(name);
			major.append(br);
			major.append(boId);
			major.style.margin='20px';
			content.append(major);
			document.getElementById("detail-table").className = "hide";

		});

// document.getElementById("major-content").onmouseover = function(){
// this.style.background = "grey";
// }

	}
	request.open("GET", "majors/list", true);
	request.send();
}

function loadStudent() {
	var content = document.getElementById("content");
	content.innerHTML = "";
	var request = new XMLHttpRequest;

	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		
		var studentJSON = JSON.parse(request.responseText);
		studentJSON.forEach(data => {
			var student = document.createElement("div");
			student.setAttribute("id",data.boId);
			student.setAttribute("onclick","getDetail(this,'STUDENT');");
			var br = document.createElement("br");
			var name = document.createElement("span");
			var boId = document.createElement("span");
			name.innerHTML = data.name;
			boId.innerHTML = data.boId;
			student.append(name);
			student.append(br);
			student.append(boId);
			student.style.margin='20px';
			content.append(student);
			document.getElementById("detail-table").className = "hide";

		});

// document.getElementById("student-content").onmouseover = function(){
// this.style.background = "grey";
// }

	}
	request.open("GET", "students/list", true);
	request.send();
}
var detailId;
function getDetail(element, entityType) {

	var request = new XMLHttpRequest;

	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		document.getElementById("detail").innerHTML = request.responseText;
		document.getElementById("detail-table").className = "show";
		
	    if(entityType == "DEPARTMENT") {
			document.getElementById("department-detail-table").className = "show";
		}
		else if(entityType == "STUDENT") {
			document.getElementById("student-detail-table").className = "show";
		}
		else if(entityType == "STAFF") {
			document.getElementById("staff-detail-table").className = "show";
		}
		else if(entityType == "TEACHER") {
			document.getElementById("teacher-detail-table").className = "show";
		}
		else if(entityType == "MAJOR") {
			document.getElementById("major-detail-table").className = "show";
		}
	}
	detailId = element;
	var boId = element.id;
	parameter = {};
	parameter["boId"] = boId;
	request.open("GET", "detail/"+ entityType + "?input=" + JSON.stringify(parameter), true);
	request.send();
}

function addNewLocation() {
	document.getElementById("locationForm").className = "show";
	document.getElementById("location-detail-table").className = "hide";
}

function saveDepartment() {
	
	var departmentName = document.getElementById("department-name").value;
	var request = new XMLHttpRequest;
	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		alert("Successfully saved!");
		loadAction("", "departments");
		document.getElementById("departmentForm").className = "hide";
	}
	
	parameter = {};
	parameter["name"] = departmentName;
	request.open("POST", "departments/create", true);
	request.setRequestHeader('Content-Type', 'application/json');
	request.send(JSON.stringify(parameter));
}


function saveMajor() {
	
	var majorName = document.getElementById("major-name").value;
	var request = new XMLHttpRequest;
	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		alert("Successfully saved!");
		loadAction("", "majors");
		document.getElementById("majorForm").className = "hide";
	}
	
	parameter = {};
	parameter["name"] = majorName;
	request.open("POST", "majors/create", true);
	request.setRequestHeader('Content-Type', 'application/json');
	request.send(JSON.stringify(parameter));
}

function getNewTeacherForm() {
	var request = new XMLHttpRequest;
	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		document.getElementById("detail").innerHTML = request.responseText;
		console.log(request.responseText);
		document.getElementById("detail-table").className = "show";
		document.getElementById("teacherForm").className = "show";		
	}
	request.open("GET", "new/teachers", true);
	request.send();
}


function getNewStaffForm() {
	var request = new XMLHttpRequest;
	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		document.getElementById("detail").innerHTML = request.responseText;
		console.log(request.responseText);
		document.getElementById("detail-table").className = "show";
		document.getElementById("staffForm").className = "show";		
	}
	request.open("GET", "new/staffs", true);
	request.send();
}

function saveTeacher() {
	
	var teacherName = document.getElementById("teacher-name").value;
	var departmentBoId = document.getElementById("department").value;
	var request = new XMLHttpRequest;
	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		alert("Successfully saved!");
		loadAction("", "teachers");
		document.getElementById("teacherForm").className = "hide";
	}
	
	parameter = {};
	parameter["name"] = teacherName;
	parameter["departmentBoId"] = departmentBoId;
	request.open("POST", "teachers/create"+"?input="+JSON.stringify(parameter),true);
	request.send();
}


function saveStaff() {
	
	var staffName = document.getElementById("staff-name").value;
	var departmentBoId = document.getElementById("department").value;
	var request = new XMLHttpRequest;
	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		alert("Successfully saved!");
		loadAction("", "staffs");
		document.getElementById("teacherForm").className = "hide";
	}
	
	parameter = {};
	parameter["name"] = staffName;
	parameter["departmentBoId"] = departmentBoId;
	request.open("POST", "staffs/create"+"?input="+JSON.stringify(parameter),true);
	request.send();
}
function getNewStudentForm() {
	var request = new XMLHttpRequest;
	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		document.getElementById("detail").innerHTML = request.responseText;
		console.log(request.responseText);
		document.getElementById("detail-table").className = "show";
		document.getElementById("studentForm").className = "show";		
	}
	request.open("GET", "new/students", true);
	request.send();
}


function saveStudent() {
	
	var studentName = document.getElementById("student-name").value;
	var majorBoId = document.getElementById("major").value;
	var request = new XMLHttpRequest;
	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		alert("Successfully saved!");
		loadAction("", "students");
		document.getElementById("studentForm").className = "hide";
	}
	
	parameter = {};
	parameter["name"] = studentName;
	parameter["majorBoId"] = majorBoId;
	request.open("POST", "students/create"+"?input="+JSON.stringify(parameter),true);
	request.send();
}

function addNewDepartment() {
	document.getElementById("department-detail-table").className = "hide";
	document.getElementById("departmentForm").className="show";
}

function addNewStaff() {
	document.getElementById("staff-detail-table").className = "hide";
}
	

function addNewMajor() {
	document.getElementById("major-detail-table").className = "hide";
	document.getElementById("majorForm").className="show";

}