<%@ include file="/jsp/init.jsp"%>

<div>
    <a ng-click="add();" class="btn btn-primary" language="add-todo"></a>
    <br/>
    <br/>
    <table class="table table-striped table-hover table-responsive">
        <thead>
            <tr>
                <th language="name"></th>
                <th language="description"></th>
                <th language="dueDate"></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <tr ng-repeat="todo in model.todos track by $index">
                <td>{{todo.name}}</td>
                <td>{{todo.description}}</td>
                <td>{{todo.dueDate | relativeDate }}</td>
                <td><a ng-click="finish(todo);" language="finish" class="action"></a></td>
            </tr>
        </tbody>
    </table>
    <span language="liferay-version"></span> : {{model.release._buildNumber}} |
    <span language="company-id"></span> : {{model.companyId}} |
    <span language="user-name"></span> : {{model.userName}}
</div>