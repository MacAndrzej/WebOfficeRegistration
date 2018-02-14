
var today = getElementByClassName('plan').value;
var dd = today.getDate();
var mm = today.getMonth()+1;

var yyyy = today.getFullYear();
if(dd<10){
    dd='0'+dd;
} 
if(mm<10){
    mm='0'+mm;
} 
console.log(today);
var today = dd+'.'+mm+'.'+yyyy;

document.write(today);