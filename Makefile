all:
	@printf "\e[35mCompiling avaj-launcher ! Executing...\e[0m\n"
	@find * -name "*.java" > sources.txt
	@javac @sources.txt
	@cd src ; java Main ../scenario.txt MD5
	@find . -name "*.class" -type f -delete
	@rm -rf sources.txt
	
	