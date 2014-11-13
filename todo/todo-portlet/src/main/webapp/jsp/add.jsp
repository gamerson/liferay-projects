<%@ include file="/jsp/init.jsp" %>

<portlet:actionURL name="addTodo" var="addTodoURL" />

<aui:form action="<%= addTodoURL %>" method="post" name="fm" >
    <aui:input name="redirect" type="hidden" value="<%= redirect %>" />

    <aui:fieldset>
        <aui:input name="name"></aui:input>
        <aui:input name="description"></aui:input>
        <aui:input cssClass="picker" name="dueDate"></aui:input>
    </aui:fieldset>
    
    ;
    <aui:fieldset>
    	<aui:input name=""></aui:input>
    	<aui:input name=""></aui:input>
    	<aui:input name=""></aui:input>
    	<aui:input name=""></aui:input>
    	<aui:input name=""></aui:input>
    </aui:fieldset>
    
<aui:button-row>
    <aui:button type="submit"></aui:button>
</aui:button-row>

</aui:form>

<aui:script>

var socket = new WebSocket("");


AUI().use('aui-datepicker', function(A) {
    var picker = new A.DatePicker({
        trigger : '.picker',
        popover : {
            zIndex : 1
        },
        on : {
            click : function(event) {
                picker.clearSelection();
            }
        }
    });
});

</aui:script>
