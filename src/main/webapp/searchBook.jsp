<div class="container">
	<div class="row">
		<div class="col-lg-12 text-center">
			<h2>Book Registry Lookup</h2>
			<hr class="star-primary">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12 text-center">
                <h2>Book Registry Lookup</h2>
         </div>
            
		<div class="col-lg-8 col-lg-offset-2">
			<form class="form-horizontal">
				<div class="form-group">
					<div class="col-sm-10">
						<input type="text" class="form-control" id="kw" placeholder="Search">
					</div>
					<div class="col-sm-1">
						<button id="search" type="button" class="btn btn-primary"><i class="glyphicon glyphicon-search"></i></button>
					</div>
					
				</div>
			</form>
		</div>
	</div>
	
	<div class="row"></div>
	
	<div class="row">
		<table class="table table-striped">
			<thead>
				<tr class="bg-primary">
					<th>Book Name</th><th>ISBN Number</th><th>Expected Date</th>
				</tr>
			</thead>
			<tbody id="results">
			
			</tbody>
		</table>
	
	</div>
</div>






<script>

$(function() {
   $('#search').click(function() {
	   var inp = {};
	   inp.kw = $('#kw').val();
	   $.ajax({
		  method:"GET",
		  data:inp,
		  url:"searchResults",
		  success:function(resp) {
			  $('#results').empty();
			  $.each(resp, function(i, book) {
				 $('#results').append(
					'<tr>'
					+'	<td>'+book.name+'</td>'
					+'	<td>'+book.isbnNumber+'</td>'
					+'	<td>'+timeConverter(book.byWhen)+'</td>'
					+'</tr>'
				 ); 
			  });
		  }
	   });
   }); 
});

function timeConverter(UNIX_timestamp){
	  var a = new Date(UNIX_timestamp );
	  var months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
	  var year = a.getFullYear();
	  var month = months[a.getMonth()];
	  var date = a.getDate();
	  var hour = a.getHours();
	  var min = a.getMinutes();
	  var sec = a.getSeconds();
	  var time = (a.getMonth()+1) + '/' + date +'/'+year;
	  return time;
	}
</script>