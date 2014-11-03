<%@ include file="/jsp/init.jsp"%>

<h2 language="add-todo"></h2>
<form role="form">
	<div class="form-group">
		<label for="name" language="name"></label>
		<input type="text" ng-model="model.currentTodo.name" class="form-control" id="name">
	</div>
	<div class="form-group">
		<label for="description" language="description"></label>
		<input type="text" ng-model="model.currentTodo.description" class="form-control" id="description">
	</div>
	<div class="form-group">
		<label for="dueDate" language="dueDate"></label>
		<input type="date" ng-model="model.currentTodo.dueDate" class="form-control" id="dueDate">
	</div>
	<button type="submit" class="btn btn-default" ng-click="store();" language="submit"></button>
	<button type="submit" class="btn btn-default" ng-click="main();" language="cancel"></button>
</form>