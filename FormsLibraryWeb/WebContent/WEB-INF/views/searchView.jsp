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
			
			$(document).ready(function() {
				$('#advancedLink').click(function() {
					$('#advancedFields').toggle();
				});
				
				resultsTable = $('#resultsTable').dataTable( {
					"bStateSave": true,
					"bSort" : true,
					"bPaginate": true,
					"iDisplayLength": 3,
					"aLengthMenu": [[1, 3, 5, 10, -1], [1, 3, 5, 10, "All"]],
					//"sAjaxSource": "${resourceUrl}"
				} );
				
				$('#clearBtn').click(function() {
					resultsTable.fnClearTable();
				});
				
				$('#submitBtn').click(function() {
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

	
<table width="985">
    <tr><td><a href="#" id="advancedLink">Advanced Search</a></td></tr>
		<tr>
		<td>
		<div id="advancedFields" class="hideme">
		  <table width="751" border="0" cellspacing="10">
		    <tr>
			    <td width="214"><label>Form Type:
			      <select name="formType2" size="3" multiple >
			        <option value="00">-- Any --
		            <option>Amendatory
		            <option>Endorsement
	                <option>Insert
	                <option>Contract
                    <option>Jacket
                    <option>Special Insert
                    <option>Customer Docs
                    <option>Billing
                    <option>U/W Correspondence
                    <option>Credit                  
                  </select>
			    </label></td>
			    <td width="218"><label>Print Category:
			      <select name="printCat" size="3" multiple id="printCat" >
			        <option>Always First</option>
			        <option>Before Dec Insert</option>
			        <option>Special</option>
			        <option>Declarations</option>
			        <option>Schedules (SPP/EE)</option>
			        <option>After Dec Insert</option>
			        <option>Policy Jacket</option>
			        <option>Policy Contract</option>
			        <option>Amendatory</option>
			        <option>Priority Endorsement</option>
		          </select>
			    </label></td>
			    <td width="283">Coverage Code:
			      <select name="printCat2" size="3" multiple id="printCat2" >
			        <option>-- Any --</option>
			        <option>All</option>
			        <option>Unit Owners Coverage - Special Coverage</option>
			        <option>Additional Insured</option>
			        <option>Additional Residence Rented to Others</option>
			        <option>Discount on Premises Alarm Systems</option>
			        <option>Additional Living Expense - Coverage E</option>
              </select></td>
		    </tr>
			  <tr>
			    <td>Event:<br>
<select name="formType" size="3" multiple >
		          <option value="00">-- Any --
		            <option>All
		            <option value="ADD">New Business
	                <option value="MOD">Amendment
	                <option>Renewal
                    <option>Cancellation
                    <option>NP Cancel
                    <option>Finalization
                    <option>Special Conversion
                    <option>Kemper Conversion
                    <option>Rewrite
                </select></td>
			    <td>Bulk Renewal:<br>
<select name="formType3" size="3" multiple >
		          <option value="00">-- Any --
		            <option>TBD
		            <option>TBD
		            <option>TBD
		            <option>TBD
                </select></td>
			    <td>Rule ID:
			      <select name="ruleId" size="3" multiple id="ruleId" >
			        <option value="00">-- Any --
		            <option>PCS - Consumer Report Disclosure
		            <option>Mueller - Consumer Report Disclosure
	                <option>LexisNexis - Consumer Report Disclosure 
	                <option>Owner Occupied 
                    <option>OWNER Occupied or no Coverage A 
                </select></td>
		      </tr>
			  <tr>
			    <td>NB Eff Date:
		        <input name="nbEffDate" type="date" id="nbEffDate"></td>
			    <td>NB Exp Date:
		        <input name="nbExpDate" type="date" id="nbExpDate"></td>
			    <td><p>Premium Indicator:<br>
<select name="contractType3" size="3" multiple id="contractType3" >
                    <option>-- Any --</option>
                      <option value="00">Y</option>
                      <option>N</option>
                    </select>
			    </p></td>
		    </tr>
			  <tr>
			    <td>REN Eff Date:<br>
                <input name="renEffDate" type="date" id="renEffDate"></td>
			    <td>REN Eff Date:<br>
                <input name="renExpDate" type="date" id="renExpDate"></td>
			    <td>Level Indicator:<br>
<select name="levelIndicator2" size="3" multiple id="levelIndicator2" >
                  <option></option>
                    <option>Policy</option>
                    <option value="00">Activity</option>
                </select></td>
		    </tr>
		  </table>
        </div>
		</td>
		</tr>
	</table>
	<table id="thetable1">
		<tr>
			<td colspan="2"></td>
			<td colspan="2"><input name="submit" type="submit" value="Search"/><input type="button" value="Clear"/></td>
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