<%@page session="false" contentType="text/html" pageEncoding="ISO-8859-1" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>        
<style type="text/css" title="currentStyle">
	@import "<%= request.getContextPath() %>/css/demo_page.css";
	@import "<%= request.getContextPath() %>/css/demo_table.css";
</style>
		<script type="text/javascript" language="javascript" src="<%= request.getContextPath() %>/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript" language="javascript" src="<%= request.getContextPath() %>/js/jquery.dataTables.columnFilter.js"></script>		
		<script type="text/javascript" charset="utf-8">
			$j(document).ready(function() {
				$j('table.datatable').dataTable( {
					"bServerSide": true,
					"bStateSave": true,
					"bSort" : true,
					"bPaginate": true,
					"iDisplayLength": 3,
					"aLengthMenu": [[1, 3, 5, 10, -1], [1, 3, 5, 10, "All"]]
				} )
				.columnFilter();
			} );
		</script>
<DIV style="margin: 6px">

<form:form name="resultsForm" method="post" action="${detailUrl}" modelAttribute="theform">
	<H3 style="margin-bottom: 3px"><a href="${searchUrl}">Back to Search</a></H3>
		

</form:form>

	<DIV style="margin: 12px; margin-bottom: 36px">
	<c:if test="${not empty formDetails}">
		<table id="<portlet:namespace/>thetable2" class="datatable">
		<thead>
		<tr>
				<th>
					Form Name
				</th>		
				<th>
					State
				</th>
				<th>
					FormEdition
				</th>
				<th>
					NB Eff Date
				</th>
				<th>
					NB Exp Date
				</th>
				<th>
					Sequence
				</th>
				<th>
					Status
				</th>
				<th>
					LOB
				</th>
				<th>
					Company
				</th>	
				<th>
					Contract Type
				</th>
				<th>
					Policy Type
				</th>			
		</tr>
		</thead>
		<tfoot>
		<tr>
				<th>
					Form Name
				</th>		
				<th>
					State
				</th>
				<th>
					FormEdition
				</th>
				<th>
					NB Eff Date
				</th>
				<th>
					NB Exp Date
				</th>
				<th>
					Sequence
				</th>
				<th>
					Status
				</th>
				<th>
					LOB
				</th>
				<th>
					Company
				</th>	
				<th>
					Contract Type
				</th>
				<th>
					Policy Type
				</th>			
		</tr>
		</tfoot>		
		<tbody>
		<c:forEach var="form" items="${formDetails}">
			<tr>
				<td>
					<c:out value="${form.formNumber}" />
				</td>
				<td>
					<c:out value="${form.state}" />
				</td>
				<td>
					<c:out value="${form.formEdition}" />
				</td>
				<td>
					<c:out value="${form.nbEffDate}" />
				</td>
				<td>
					<c:out value="${form.nbExpDate}" />
				</td>
				<td>
					<c:out value="${form.sequence}" />
				</td>
				<td>
					<c:out value="${form.status}" />
				</td>
				<td>
					<c:out value="${form.lob}" />
				</td>
				<td>
					<c:out value="${form.company}" />
				</td>	
				<td>
					<c:out value="${form.contractType}" />
				</td>
				<td>
					<c:out value="${form.policyType}" />
				</td>																	
			</tr>
		</c:forEach>
		</tbody>
		
		</table>
	</c:if>
	
<% /******** End of sample code *********/ %>
</DIV>
</DIV>