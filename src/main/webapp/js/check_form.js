/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





function validate_form()
{
 
 Montant =    document.forms["Add_acompte"]["Montant"].value;
 Type =    document.forms["Add_acompte"]["Type"].value;
   if (Montant == "" ||  Type == "" ){
        var popup = document.getElementById("warn");
          popup.classList.toggle("show");
          return false ;
   }else{
       //  alert("Please insert a value in required fields !");
          return true;
   }
 
}







