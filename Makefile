
# $(NAME): mkdir -p obj/

all: 
	@mkdir -p obj/
	@find * -name "*.java" > obj/sources.txt
	@javac @obj/sources.txt
	@cd src ; java Main
	cp -rf src/*.class obj/