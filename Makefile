# Makefile for CSE-212-assignments

# Define the student number (replace with your actual student number)
STUDENT_NUMBER = 20220701005

# Define the source files
SOURCES = $(wildcard src/*.java)

# Define the name of the zip file
ZIP_FILE = $(STUDENT_NUMBER).zip

# The default target
all: $(ZIP_FILE)

# Create the zip file
$(ZIP_FILE): $(SOURCES)
	@echo "Creating zip file: $(ZIP_FILE)"
	@zip -j $(ZIP_FILE) $(SOURCES)
	@echo "Zip file created successfully."

# Clean the zip file
clean:
	@rm -f $(ZIP_FILE)

.PHONY: all clean
