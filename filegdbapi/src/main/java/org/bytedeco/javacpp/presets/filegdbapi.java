package org.bytedeco.javacpp.presets;

import org.bytedeco.javacpp.annotation.*;
import org.bytedeco.javacpp.tools.*;

import java.lang.annotation.*;

@Properties(
        target="org.bytedeco.javacpp.filegdbapi",
        value={
                @Platform(
                        include={"FileGDBCore.h", /*"<algorithm>",*/ "filegdbapi_adapters.h"},
                        link="FileGDBAPI@.1.4"),
                @Platform(value="windows", link="libFileGDBAPI.so", preload="FileGDBAPI")})
public class filegdbapi implements InfoMapper {
    public void map(InfoMap infoMap) {
        infoMap.put(new Info("algorithm", "filegdbapi_adapters.h").skip())
                .put(new Info("std::wstring").skip().annotations("@StdWstring").valueTypes("BytePointer", "String"))
                .put(new Info("SUCCEEDED","FAILED","S_OK","S_FALSE","E_FAIL","E_INVALIDARG","E_NOTIMPL",
                        "E_OUTOFMEMORY","E_POINTER","E_NOINTERFACE", "E_UNEXPECTED","E_ACCESSDENIED").skip())
                .put(new Info(
                        "FGDB_E_FILE_NOT_FOUND",
                        "FGDB_E_PATH_NOT_FOUND",
                        "FGDB_E_ACCESS_DENIED",
                        "FGDB_E_CANNOT_MAKE",
                        "FGDB_E_SEEK",
                        "FGDB_E_INVALID_HANDLE",
                        "FGDB_E_FILE_EXISTS",
                        "FGDB_E_HANDLE_DISK_FULL",
                        "FGDB_E_NO_PERMISSION",
                        "FGDB_E_NOT_SUPPORTED",
                        "FGDB_E_FILE_IO",
                        "FGDB_E_FIELD_NOT_FOUND",
                        "FGDB_E_FIELD_INVALID_NAME",
                        "FGDB_E_FIELD_NOT_NULLABLE",
                        "FGDB_E_FIELD_NOT_EDITABLE",
                        "FGDB_E_FIELD_INVALID_TYPE",
                        "FGDB_E_FIELD_ALREADY_EXISTS",
                        "FGDB_E_FIELDS_MULTIPLE_OIDS",
                        "FGDB_E_FIELDS_MULTIPLE_GEOMETRIES",
                        "FGDB_E_FIELDS_MULTIPLE_RASTERS",
                        "FGDB_E_FIELDS_MULTIPLE_GLOBALIDS",
                        "FGDB_E_FIELDS_EMPTY",
                        "FGDB_E_FIELD_CANNOT_DELETE_REQUIRED_FIELD",
                        "FGDB_E_TABLE_INVALID_NAME",
                        "FGDB_E_TABLE_NOT_FOUND",
                        "FGDB_E_TABLE_ALREADY_EXISTS",
                        "FGDB_E_TABLE_NO_OID_FIELD",
                        "FGDB_E_DATASET_INVALID_NAME",
                        "FGDB_E_DATASET_ALREADY_EXISTS",
                        "FGDB_E_INDEX_NOT_FOUND",
                        "FGDB_E_GRID_SIZE_TOO_SMALL",
                        "FGDB_E_INVALID_GRID_SIZE",
                        "FGDB_E_NO_SPATIALREF",
                        "FGDB_E_INVALID_SQL",
                        "FGDB_E_XML_PARSE_ERROR",
                        "FGDB_E_SPATIALFILTER_INVALID_GEOMETRY",
                        "FGDB_E_SPATIALREF_INVALID",
                        "FGDB_E_WORKSPACE_ALREADY_EXISTS",
                        "FGDB_E_INVALID_RELEASE",
                        "FGDB_E_LOCK_CONFLICT",
                        "FGDB_E_SCHEMA_LOCK_CONFLICT",
                        "FGDB_E_OBJECT_NOT_LOCKED",
                        "FGDB_E_WORKSPACE_READONLY",
                        "FGDB_E_CANNOT_EDIT_COMPRESSED_DATASET",
                        "FGDB_E_CANNOT_UPDATE_COMPRESSED_DATASET",
                        "FGDB_E_COMPRESSED_DATASET_NOT_INSTALLED",
                        "FGDB_E_NEGATIVE_FID",
                        "FGDB_E_FEATURE_VALUE_TYPE_MISMATCH",
                        "FGDB_E_ROW_BAD_VALUE",
                        "FGDB_E_ROW_ALREADY_EXISTS",
                        "FGDB_E_ROW_NOT_FOUND",
                        "FGDB_E_TABLE_SIZE_EXCEEDED",
                        "FGDB_E_NOT_EDITING",
                        "FGDB_E_EDIT_OPERATION_REQUIRED",
                        "FGDB_E_CANNOT_CHANGE_ITEM_VISIBILITY",
                        "FGDB_E_ITEM_NOT_FOUND",
                        "FGDB_E_ITEM_RELATIONSHIP_NOT_FOUND",
                        "FGDB_E_DOMAIN_NOT_FOUND",
                        "FGDB_E_DOMAIN_NAME_ALREADY_EXISTS",
                        "FGDB_E_DOMAIN_INVALID_NAME ").skip())
                .put(new Info("FileGDBAPI::fgdbError").cast().valueTypes("int"))
                //.put(new Info("FileGDBAPI::FieldType"))
                //.put(new Info("(fgdbError)").cppText(""))
                //.put(new Info("S_OK").cppTypes("int").translate())


         ;


//                 .put(new Info("ZEXTERN", "ZEXPORT", "z_const", "zlib_version").cppTypes().annotations())
//                .put(new Info("FAR").cppText("#define FAR"))
//                .put(new Info("OF").cppText("#define OF(args) args"))
//                .put(new Info("Z_ARG").cppText("#define Z_ARG(args) args"))
//                .put(new Info("Byte", "Bytef", "charf").cast().valueTypes("byte").pointerTypes("BytePointer"))
//                .put(new Info("uInt", "uIntf").cast().valueTypes("int").pointerTypes("IntPointer"))
//                .put(new Info("uLong", "uLongf", "z_crc_t", "z_off_t").cast().valueTypes("long").pointerTypes("CLongPointer"))
//                .put(new Info("z_off64_t").cast().valueTypes("long").pointerTypes("LongPointer"))
//                .put(new Info("voidp", "voidpc", "voidpf").valueTypes("Pointer"))
//                .put(new Info("gzFile_s").pointerTypes("gzFile"))
//                .put(new Info("gzFile").valueTypes("gzFile"))
//                .put(new Info("Z_LARGE64", "!defined(ZLIB_INTERNAL) && defined(Z_WANT64)").define(false))
//                .put(new Info("inflateGetDictionary", "gzopen_w", "gzvprintf").skip());
    }

    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD, ElementType.PARAMETER})
    @Cast({"std::wstring&"}) @Adapter("WstringAdapter") public @interface StdWstring { }
}
