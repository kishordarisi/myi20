$( document ).ready(function() {
var txt= $('#apppro p').text();
if(txt.length > 155)
$('#apppro p').text(txt.substring(0,150) + '...');
/*--------- 2 ----------------*/
var txt8= $('#inhouse p').text();
if(txt8.length > 155)
$('#inhouse p').text(txt8.substring(0,150) + '...');
/*--------- 3 ----------------*/
var txt1= $('#abroad p').text();
if(txt1.length > 155)
$('#abroad p').text(txt1.substring(0,150) + '...');
/*--------- 4 ----------------*/
var txt2= $('#scholorship p').text();
if(txt2.length > 155)
$('#scholorship p').text(txt2.substring(0,150) + '...');
/*--------- 5 ----------------*/
var txt3= $('#sop p').text();
if(txt3.length > 155)
$('#sop p').text(txt3.substring(0,150) + '...');
/*--------- 6 ----------------*/
var txt4= $('#selectinguniversity p').text();
if(txt4.length > 155)
$('#selectinguniversity p').text(txt4.substring(0,150) + '...');
/*--------- 7 ----------------*/
var txt5= $('#applicationprocedure p').text();
if(txt5.length > 155)
$('#applicationprocedure p').text(txt5.substring(0,150) + '...');
/*--------- 8 ----------------*/
var txt6= $('#applicationprocess p').text();
if(txt6.length > 155)
$('#applicationprocess p').text(txt6.substring(0,150) + '...');
/*--------- 9 ----------------*/
var txt7= $('#visa p').text();
if(txt7.length > 155)
$('#visa p').text(txt7.substring(0,150) + '...');
});