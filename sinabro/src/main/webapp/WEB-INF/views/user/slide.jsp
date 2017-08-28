<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/sinabro/js/jquery-3.2.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="/sinabro/js/user/product/productSlide.js"></script>
<script src="/sinabro/js/user/product/productSlide.min.js"></script>

<link rel="stylesheet" href="/sinabro/css/user/main/slide.css" />


<script>
	$(document).ready(function() {
		var slider = $('.bxslider').bxSlider({
			auto : true,
			mode : 'fade',
		});
		// 클릭시 멈춤 현상 해결 //
		$(document).on('click', '.bx-next, .bx-prev', function() {
			slider.stopAuto();
			slider.startAuto();
			slider_01.stopAuto();
			slider_01.startAuto();
		});
		$(document).on('mouseover', '.bx-pager, #bx-pager1', function() {
			slider.stopAuto();
			slider.startAuto();
			slider_01.stopAuto();
			slider_01.startAuto();
			slider_02.stopAuto();
			slider_02.startAuto();
		});
	});
	function openCity(cityName, elmnt, color) {
	    // Hide all elements with class="tabcontent" by default */
	    var i,  tabcontent, tablinks;
	    tabcontent =  document.getElementsByClassName("tabcontent");
	    for (i =  0; i < tabcontent.length; i++) {
	         tabcontent[i].style.display = "none";
	    }
	 
	    // Remove the background color of all tablinks/buttons
	     tablinks = document.getElementsByClassName("tablink");
	     for (i = 0; i < tablinks.length; i++) {
	         tablinks[i].style.backgroundColor = "";
	    }
	 
	    // Show the specific tab content
	     document.getElementById(cityName).style.display = "block";

	     // Add the specific color to the button used to open the tab content
	     elmnt.style.backgroundColor = color;
	}
	// Get the element with id="defaultOpen" and click on it
	$(document).ready(function() {
		document.getElementById("defaultOpen").click();	
	});
</script>



</head>
<body>
<div>
			<div id="s_banner_wrap">
			<ul class="bxslider">
			<li><img src="/sinabro/images/mainPic1.png" style="width:930px ;height:280px" alt="광고슬라이드"></li>
			<li><img src="/sinabro/images/mainPic2.png"style="width:930px ;height:280px" alt="광고슬라이드"></li>
			<li><img src="/sinabro/images/mainPic3.png" style="width:930px ;height:280px"alt="광고슬라이드"></li>
			<li><img src="/sinabro/images/mainPic4.png"style="width:930px ;height:280px" alt="광고슬라이드"></li>
			</ul>
	</div>
	</div>
</body>
</html>