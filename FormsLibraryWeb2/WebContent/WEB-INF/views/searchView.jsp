<%@page session="false" contentType="text/html" pageEncoding="ISO-8859-1" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>        
<style type="text/css" title="currentStyle">
	@import "<%= request.getContextPath() %>/resources/css/demo_page.css";
	@import "<%= request.getContextPath() %>/resources/css/demo_table.css";
</style>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
		<script type="text/javascript" language="javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.1/jquery-ui.min.js"></script>
		<script type="text/javascript" language="javascript" src="<%= request.getContextPath() %>/resources/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript" language="javascript" src="<%= request.getContextPath() %>/resources/js/jquery.dataTables.js"></script>
		<script type="text/javascript" charset="utf-8">
			var resultsTable;
			var resultsData = [["AK1111", "FAIR Credit", "link", "button"]];
			
			$j(document).ready(function() {
				$j('#advancedLink').click(function() {
					$j('#advancedFields').toggle();
				});
				
				resultsTable = $j('#resultsTable').dataTable( {
					"bStateSave": true,
					"bSort" : true,
					"bPaginate": true,
					"iDisplayLength": 3,
					"aLengthMenu": [[1, 3, 5, 10, -1], [1, 3, 5, 10, "All"]],
					"sAjaxSource": "${resourceUrl}"
				} );
				
				$j('#clearBtn').click(function() {
					resultsTable.fnClearTable();
				});
				
				$j('#submitBtn').click(function() {
					//ajax call
					resultsTable.fnDraw();
				});

			} );
		</script>
</head>
<body>
<DIV style="margin: 6px">

<H3 style="margin-bottom: 3px">Search Criteria</H3>
<form:form name="searchForm" method="post" action="${searchUrl}" modelAttribute="searchCriteria">

	
	<table width="757" border="0" id="searchTable">
	  <tr>
		<td width="244"><table width="100%" border="0" cellspacing="10">
		  <tr>
			<td width="193"><p><label for="formNumber">Form Number:</label><span class="input">
	
			  <form:input type="text" name="formNumber" path="formName"/>
			  </span></p>
			  <p><label for="formName">Form Name:</label><span class="input">
				<form:input type="text" name="formName" path="formTitle"/>
				</span></p>
			</td>

			<td width="94"><label for="state">State:</label>
			   <form:select size="5" name="state" path="states" itemValue="key" itemLabel="value">
	  			<form:option value="00" label="All States"/>
	  			<form:options items="${listValues.stateList}" itemValue="key" itemLabel="value" />
			</form:select></td>
			<td width="124"><label for="lob">Line Of Business</label>
			  <form:select size="5" name="lob" path="lobs">
	  			<form:option value="00" label="All" />
	  			<form:options items="${listValues.lobList}" itemValue="key" itemLabel="value" />
			</form:select></td>
			<td width="108"><label for="contractType">Contract Type</label>
			  <form:select size="5" name="contractType" path="policyTypes">
	  			<form:option value="00" label="All"/>
	  			<form:options items="${listValues.policyTypeList}" itemValue="key" itemLabel="value" />
			</form:select></td>
			<td width="192"><label for="company">Company</label>
			  <form:select size="5" name="company" path="company">
	  			<form:option value="00" label="All"/>
	  			<form:options items="${listValues.companyList}" itemValue="key" itemLabel="value" />
			</form:select></td>
			</tr>
		  </table></td>
	  </tr>
	</table>

	
	<table>
		<tr><td><a href="#" id="advancedLink">Advanced Search</a></td></tr>
		<tr>
		<td>
		<div id="advancedFields">
			<table>
				<tr>
				<td><label>Form Type:</label></td>
				<td><form:select name="formType" path="formType">
		  			<form:option value="00" label="All"/>
		  			<form:options items="${listValues.formTypeList}" itemValue="key" itemLabel="value" />
				</form:select></td>
				</tr>
			
			</table>
		</div>
		</td>
		</tr>
	</table>
	<table>
		<tr>
			<td colspan="2"></td>
			<td colspan="2"><input id="submitBtn" class="first" type="button" value="Search"/><input id="clearBtn" type="button" value="Clear"/></td>
		</tr>
	</table>
</form:form>

<form:form name="resultsForm" method="post" action="${detailUrl}" modelAttribute="theform">	
	<DIV style="margin: 12px; margin-bottom: 36px">
	
		<table id="resultsTable" class="datatable">
		<thead>
		<tr>
			<th>Form Number</th>
			<th>Form Title</th>
			<th>Form Type</th>			
			<th>Options</th>			
		</tr>
		</thead>
		<tbody>
		<!-- s
		<c:forEach var="form" items="${searchResults}">
			<tr>
				<td>
					<c:out value="${form.formNumber}" />
				</td>
				<td>
					<c:out value="${form.formTitle}" />
				</td>
				<td>
					<c:out value="${form.formType}" />
				</td>
				<td>
					<form:button value="View Details"/>
					<input type="hidden" value="${form.formNumber }" name="formname"/>
				</td>									
			</tr>
		</c:forEach>
		 -->
		</tbody>
		</table>
	
	
<% /******** End of sample code *********/ %>
</DIV>
</form:form>

</DIV>
</body>
</html>