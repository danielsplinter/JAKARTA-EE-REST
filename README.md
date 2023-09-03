# JAKARTA-EE-REST
Feito com JAKARTA EE 9</br>
End points abaixo</br>

GET para listar todos os produtos:</br>
http://localhost:8080/samplerestful/api/produtos
  
-------------------------------------------------------------------
GET para listar todos um produto por id:</br>
http://localhost:8080/samplerestful/api/produtos/1

-------------------------------------------------------------------
POST para salvar um produto:</br>
http://localhost:8080/samplerestful/api/produtos/1</br>

  json de exemplo:</br>
    {
      "descricao": "computador",
      "valor": 2000
    }

-------------------------------------------------------------------
DELETE para deletar um produto por id:</br>
http://localhost:8080/samplerestful/resources/products/1
