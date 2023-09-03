# JAKARTA-EE-REST
Feito com JAKARTA EE 9
End points abaixo

GET para listar todos os produtos:</br>
http://localhost:8080/samplerestful/api/produtos
  
-------------------------------------------------------------------
GET para listar todos um produto por id:</br>
http://localhost:8080/samplerestful/api/produtos/1

-------------------------------------------------------------------
POST para salvar um produto:</br>
http://localhost:8080/samplerestful/api/produtos/1

  json de exemplo:</br>
    {</br>
      "descricao": "computador",</br>
      "valor": 2000</br>
    }</br>

-------------------------------------------------------------------
DELETE para deletar um produto por id:</br>
http://localhost:8080/samplerestful/resources/products/1
