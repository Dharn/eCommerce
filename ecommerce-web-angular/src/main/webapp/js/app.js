(function() {
	var app = angular.module("formapp", [ "module", "formation", "ressource","eleve" , "formateur"]);

	app.controller("SwitchController", function() {
		this.onglet = "module";

		this.setOnglet = function(val) {
			this.onglet = val;
		};

		this.isOnglet = function(val) {
			return this.onglet === val;
		}
	});

})();
