# JAKARTA-EE-REST
Feito com JAKARTA EE 9
End points abaixo

GET para listar todos os produtos:</br>
  http://localhost:8080/samplerestful/api/produtos
  
-------------------------------------------------------------------
GET para listar todos um produto por id:
  http://localhost:8080/samplerestful/api/produtos/1

-------------------------------------------------------------------
POST para salvar um produto:
  http://localhost:8080/samplerestful/api/produtos/1

  json de exemplo: 
    {
      "descricao": "computador",
      "valor": 2000
    }

-------------------------------------------------------------------
DELETE para deletar um produto por id:
  http://localhost:8080/samplerestful/resources/products/1
