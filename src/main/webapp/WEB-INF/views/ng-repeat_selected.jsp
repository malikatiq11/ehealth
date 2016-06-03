<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title></title>
</head>
<body>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.9/angular.min.js"></script>
    <script type="text/javascript">
        var app = angular.module('MyApp', [])
        app.controller('MyController', function ($scope) {
            $scope.Fruits = [{
                Id: 1,
                Name: 'Apple',
                Selected: false
            }, {
                Id: 2,
                Name: 'Mango',
                Selected: true
            }, {
                Id: 3,
                Name: 'Orange',
                Selected: false
            }];
        });
    </script>
    <div ng-app="MyApp" ng-controller="MyController">
        <select>
            <option value = "0" label = "Please Select"></option>
            <option ng-repeat="fruit in Fruits" value="{{fruit.Id}}" 
                        ng-selected="{{ fruit.Selected == true }}">
                {{fruit.Name}}
            </option>
        </select>
    </div>
</body>
</html>
