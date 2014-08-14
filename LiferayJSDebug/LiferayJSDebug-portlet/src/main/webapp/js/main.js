function objectInspector(object, rows, indent, result) {
  if (typeof object != "object")
    return "Invalid object";
  if (typeof result == "undefined")
    result = '';
  if (typeof indent == "undefined")
    indent = '';

  //if (result.length > 50)
  //return "[RECURSION TOO DEEP. ABORTING.]";

  for ( var property in object) {
    try {
      var datatype = typeof object[property];

      var tempDescription = result + '"' + property + '"';
      tempDescription += ' (' + datatype + ') => ';
      //if (datatype == "object")
      //    tempDescription += 'object: '+objectInspector(object[property],result+'  ');
      //else
      //    tempDescription += object[property];

      rows.push(indent + tempDescription);

      if (indent.length < 3
          && datatype == "object"
          && tempDescription != "\"_yuievt\" (object) => "
          && tempDescription != "\"_topWindow\" (object) => "
          && tempDescription != "\"lastElementChild\" (object) => "
          && tempDescription != "\"firstElementChild\" (object) => "
          && tempDescription != "\"children\" (object) => "
          && tempDescription != "\"nextElementSibling\" (object) => "
          && tempDescription != "\"lastElementSibling\" (object) => "
          && tempDescription != "\"previousElementSibling\" (object) => "
          && tempDescription != "\"offsetParent\" (object) => "
          && tempDescription != "\"style\" (object) => "
          && tempDescription != "\"ownerElement\" (object) => "
          && tempDescription != "\"ownerDocument\" (object) => "
          && tempDescription != "\"lastChild\" (object) => "
          && tempDescription != "\"firstChild\" (object) => "
          && tempDescription != "\"childNodes\" (object) => "
          && tempDescription != "\"parentNode\" (object) => "
          && tempDescription != "\"_yuid\" (object) => "
          && tempDescription != "\"_node\" (object) => "
          && tempDescription != "\"PREVIEW_PANEL\" (object) => "
          && tempDescription != "\"_stateProxy\" (object) => "
          && tempDescription != "\"attributes\" (object) => "
          && tempDescription != "\"_baseDelegateHandle\" (object) => ")
        objectInspector(object[property], rows, indent + '   ');
    } catch (error) {

    }
  }//Close for

  return rows.join(result + "\n");
}

function debugJS(retval) {
  Liferay.Service(
    '/LiferayJSDebug-portlet.liferayjsdebug/debug-js',
    {
      log : objectInspector(Liferay, retval)
    },
    function(obj) {
      console.log(obj);
    }
  );
}
