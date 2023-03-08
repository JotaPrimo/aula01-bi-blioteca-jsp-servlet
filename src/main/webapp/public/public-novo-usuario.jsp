<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/css/bootstrap.min.css"
	rel="stylesheet" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
</head>

<body>
	<!-- barra de navegação -->
	<jsp:include page="/public/public-nav.jsp"></jsp:include>

	<!-- container -->
	<div class="container">
		<div class="row mt-5">
			<div class="col">
				<h2>Cadastro de Usuario</h2>
				
				<c:if test="${mensagem != null}">
				 	<div class="alert alert-success alert-dismissible fade show">
					<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
					<span><c:out value="${mensagem}" /></span>
				</div>
				</c:if>	
				
				
				<div class="card">
					<div class="card-body">
						<form action="${pageContext.request.contextPath}/publica?acao=inserir" method="POST">
							<div class="mb-3">
								<div class="row">
									<div class="col-md-4 col-sm-12 mb-3">
										<label for="exampleInputEmail1" class="form-label">Nome</label>
										<input type="text" name="nome" required placeholder="Nome" minlength="3" maxlength="20" class="form-control">
									</div>

									<div class="col-md-4 col-sm-12 mb-3">
										<label for="exampleInputEmail1" class="form-label">CPF</label>
										<input type="text" class="form-control" name="cpf" required placeholder="CPF" minlength="11" maxlength="11">
									</div>

									<div class="col-md-4 col-sm-12 mb-3">
										<label for="exampleInputEmail1" class="form-label">Nascimento</label>
										<input type="text" name="dataNascimento" required="required" class="form-control">
									</div>
								</div>


								<div class="row">
									<div class="col-md-4 col-sm-12 mb-3">
										<label for="exampleInputEmail1" class="form-label">Email</label>
										<input type="email" class="form-control" name="email" required placeholder="Email" minlength="3" maxlength="50">
									</div>

									<div class="col-md-4 col-sm-12 mb-3">
										<label for="exampleInputEmail1" class="form-label">Login</label>
										<input type="text" class="form-control" name="login" required placeholder="Login" minlength="3" maxlength="50">
									</div>

									<div class="col-md-4 col-sm-12 mb-3">
										<label for="exampleInputEmail1" class="form-label">Senha</label>
										<input type="password" class="form-control" name="senha" required placeholder="Senha" minlength="3" maxlength="50">
									</div>

								</div>

								<button type="submit" class="btn btn-primary">Salvar</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>