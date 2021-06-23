/**
 * Consistencias das páginas
 */

//------------------------------------------------------------

function consdata(){  
var dt=document.getElementById("dth").value;
var ano = dt.substring(6, 10);
var mes = dt.substring(3,5);
var dia = dt.substring(0,2);
var x = (ano+"-"+mes+"-"+dia);
var year=new Date();
var anoh = (year.getUTCFullYear());
var mes1 = new Date();
var mes2 = (mes1.getMonth()+1);
if (mes2 <10)
{
	var zero = "0";
 	var mesh = (zero.concat(mes2));
}
else
{
	var mesh = mes2;
}
var dia1=new Date();
var diah = (dia1.getDate());
var h = (anoh+"-"+mesh+"-"+diah);
if(x < h)
{
	alert("A data do exame deve ser posterior a data de hoje");
}
else
{
	document.getElementById("numCPF").value = document.getElementById("numCPF").value.replace(/[^\d]+/g,'');
	var w = (ano.concat(mes,dia));
	document.getElementById("dth").value = new String(w);
	var hr=document.getElementById("horaExame").value;
	var hh = hr.substring(0, 2);
	var mm = hr.substring(3,5);
	var z = (hh.concat(mm));
	document.getElementById("horaExame").value = new String(z);
	
	
	form1.submit();	
}

}


function incpf() {

 	document.getElementById("numCPF").value = document.getElementById("numCPF").value.replace(/[^\d]+/g,'');
 	form1.submit();
}



function digita(obj, texto) {
    obj = obj.nodeName ? obj : document.getElementById(obj);
    var len = obj.innerHTML.length;
    if (len < texto.length) {
        obj.innerHTML = texto.substring(0, len + 1);
        setTimeout(function () { digita(obj, texto); }, 50);
    }
}

var v_obj;
var v_fun;
var keyCode;
function mascaraMutuario(o, f, e) {
    v_obj = o;
    v_fun = f;
    keyCode = e.keyCode;
    setTimeout('execmascara()', 1);
}

function execmascara() {
    var c = String.fromCharCode(keyCode);
    var isWordcharacter = c.match(/\w/);
    var isDigit = (keyCode === 8 || keyCode === 46 || (keyCode >= 48 && keyCode <= 57) || (keyCode >= 96 && keyCode <= 105));
    if (isWordcharacter || isDigit) {
        v_obj.value = v_fun(v_obj.value);
    }
}

function cpfCnpj(v) {
    //Remove tudo o que não é dígito
    v = v.replace(/\D/g, "");

    if (v.length <= 11) { //CPF
        //Coloca um ponto entre o terceiro e o quarto dígitos
        v = v.replace(/(\d{3})(\d)/, "$1.$2");
        //Coloca um ponto entre o terceiro e o quarto dígitos
        //de novo (para o segundo bloco de números)
        v = v.replace(/(\d{3})(\d)/, "$1.$2");
        //Coloca um hífen entre o terceiro e o quarto dígitos
        v = v.replace(/(\d{3})(\d{1,2})$/, "$1-$2");
    } else { //CNPJ
        //Coloca ponto entre o segundo e o terceiro dígitos
        v = v.replace(/^(\d{2})(\d)/, "$1.$2");
        //Coloca ponto entre o quinto e o sexto dígitos
        v = v.replace(/^(\d{2})\.(\d{3})(\d)/, "$1.$2.$3");
        //Coloca uma barra entre o oitavo e o nono dígitos
        v = v.replace(/\.(\d{3})(\d)/, ".$1/$2");
        //Coloca um hífen depois do bloco de quatro dígitos
        v = v.replace(/(\d{4})(\d)/, "$1-$2");
    }

    return v;
}

function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

$(document).ready(function () {
    //digita('cont', 'Uma empresa de sucesso valoriza e respeita as pessoas que nela trabalham, conquista e mantém mercados, adapta-se permanentemente às mudanças e atua sempre com ética e responsabilidade social. O Itaú - Unibanco é assim. Diversas iniciativas institucionais reafirmam este compromisso, com destaque às ações voltadas à Gestão de Pessoas. A modernização e o aprimoramento dos atuais planos de saúde são uma prova disto.');
    
    var mensagem = getParameterByName("erro");
    if (mensagem !== "") {
        alert("Beneficiário não encontrado: " + mensagem);
    }
});


function validar(){
    var dt=document.getElementById("dth").value;
	var ano = dt.substring(6, 10);
	var mes = dt.substring(3,5);
	var dia = dt.substring(0,2);
	    switch(mes){
     case 01: case 03: case 05: case 07: 
     case 08: case 10: case 12:
      if(dia <= 31)
       resposta.innerHTML = "Data válida";
      else
       alert("Data invalida - mes com mais de 31 dias");
      break ;
     case 04: case 06:
     case 09: case 11:
      if(dia <= 30)
       resposta.innerHTML = "Data válida";
      else
       alert("Data invalida - mes com mais de 30 dias");
      break ;
     case 02:
      if( (ano%400 == 0) || (ano%4==0 && ano%100!=0) )
       if( dia <= 29)
        resposta.innerHTML = "Data válida";
       else
        alert("Data invalida - mes com mais de 29 dias");
      else
       if( dia <= 28)
        resposta.innerHTML = "Data válida";
       else
        alert("Data invalida - mes com mais de 28 dias");
    }
}

        
        function data(v) {
            //Remove tudo o que não é dígito
            v = v.replace(/\D/g, "");

            if (v.length <= 10) { //data DDMMAAAA
                //Coloca uma barra entre o segundo e o terceiro dígitos
                v = v.replace(/(\d{2})(\d)/, "$1/$2");
                //Coloca uma barra entre o segundo e o terceiro dígitos
                //de novo (para o segundo bloco de números)
                v = v.replace(/(\d{2})(\d)/, "$1/$2");
                
            } else { 
            }

            return v;
        }

        function hora(v) {
            //Remove tudo o que não é dígito
            v = v.replace(/\D/g, "");

            if (v.length <= 5) { //hora HHMM
                //Coloca dois pontos entre o segundo e o terceiro dígitos
                v = v.replace(/(\d{2})(\d)/, "$1:$2");
                                
            } else { 
            }

            return v;
        }
        
        function num(v) {
            //Remove tudo o que não é dígito
            v = v.replace(/\D/g, "");

            return v;
        }
        
        function voltar() {
        	history.go(-1);
            }
       


