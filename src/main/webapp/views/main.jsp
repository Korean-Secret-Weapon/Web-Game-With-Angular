     <div id="userInfo" class="panel panel-default" style="position:absolute;width:15%;margin:20px 10px 10px 10px;">
	  <div class="panel-heading">User Infomation</div>
	  <div class="panel-body">
	    <span id="name" ng-model="name">{{name}}</span>
	  </div>
	</div>
    <div class="col-sm-10 container" style="left:18%;width:70%;">
    	<div class="page-header">
		  <h1>Notice</h1>
		</div>
      <table class="table table-bordered">
        <thead>
          <tr>
          	<th>No.</th>
            <th>Title</th>
            <th>Writer</th>
            <th>Date</th>
          </tr>
        </thead>
        <tbody>
          <tr ng-repeat='item in items'>
          	<td>{{$index+1}}</td>
			<td>{{item.EMPNO}}</td>
			<td>{{item.ENAME}}</td>
			<td>{{item.JOB}}</td>
          </tr>
        </tbody>
      </table>
      <div class="pager">
	      <ul class="pagination">
			  <li><a href="">«</a></li>
			  <li><a href="">1</a></li>
			  <li><a href="">2</a></li>
			  <li><a href="">3</a></li>
			  <li><a href="">4</a></li>
			  <li><a href="">5</a></li>
			  <li><a href="">»</a></li>
		   </ul>
		</div>
    </div>