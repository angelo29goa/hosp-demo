angular.module('hosp', ['ngResource', 'ui.bootstrap']).
    factory('Hospitals', function ($resource) {
        return $resource('findallhosp');
    }).
    factory('Patients', function ($resource) {
        return $resource('findpatofhosp', {hospName: '@hospName'});
    }). 
	factory('Exams', function ($resource) {
        return $resource('findexamofpat', {patName: '@patName'});
    });

function HospController($scope, Hospitals, Patients, Exams) {
    function list() {
        $scope.hospitals = Hospitals.query(function () {			            
        		addSelectedToHospList();
		        },
		     function (result) {
		           alert("Error " + result);
		        });
    }
	function queryPatients() {
        $scope.patients = Patients.query({hospName: $scope.selectedHosp.name},function () {			            
        		addSelectedToPatients();
		        },
		     function (result) {
		           alert("Error " + result);
		        });
    }
	
	function queryExam() {
        $scope.exams = Exams.query({patName: $scope.selectedPatient.firstname},function () {			            
        		addSelectedToPatients();
		        },
		     function (result) {
		           alert("Error " + result);
		        });
    }
	
	function addSelectedToPatients(){
    	var patLen = $scope.patients.length;
    	for(i=0;i<patLen;++i){
    		var pat =  $scope.patients[i];
    		pat.selected = "";
    	}
    	
    }
	
	function addSelectedToHospList(){
    	var hospLen = $scope.hospitals.length;
    	for(i=0;i<hospLen;++i){
    		var hosp =  $scope.hospitals[i];
    		hosp.selected = "";
    	}
    	
    }
	$scope.onHospitalSelect = function(hospital){
    	$scope.selectedHosp = hospital;
    	var hospLen = $scope.hospitals.length;
    	for(i=0;i<hospLen;++i){
    		var hosp =  $scope.hospitals[i];
    		hosp.selected = "";
    	}    	
    	hospital.selected = "selected";
		queryPatients();
    	//$scope.updateView($scope.viewTypeSelected);
    	$scope.$broadcast('refreshViews', [1,2,3]);
    }
	
	$scope.onPatientSelect = function(patient){
    	$scope.selectedPatient = patient;
    	var patLen = $scope.patients.length;
    	for(i=0;i<patLen;++i){
    		var pat =  $scope.patients[i];
    		pat.selected = "";
    	}    	
    	pat.selected = "selected";
		queryExam();
    	//$scope.updateView($scope.viewTypeSelected);
    	$scope.$broadcast('refreshViews', [1,2,3]);
    }
	
	
    function clone (obj) {
        return JSON.parse(JSON.stringify(obj));
    }

    $scope.init = function() {
        list();      
    };
}
