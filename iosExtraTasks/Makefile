XC_FRAMEWORK_FOLDER = ../build/XCFrameworks
LIBNAME = SDUIEngine
FRAMEWORK_NAME = ${LIBNAME}.xcframework
BUILD_TYPE = debug
BUILD_FOLDER = ${XC_FRAMEWORK_FOLDER}/${BUILD_TYPE}

--create-sp: #--zip --checksum
	@echo "Create Package.swift file"
	@touch Package.swift
	@cp Package.swift.tmpl Package.swift
	@sed -I -n "s/<lib\/>/${LIBNAME}/g" Package.swift
	@rm Package.swift-n

--move-pkg-to-folder:
	@cp Package.swift ${BUILD_FOLDER}/Package.swift
	@rm Package.swift

update-build-package: --create-sp --move-pkg-to-folder








