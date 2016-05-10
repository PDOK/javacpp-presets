#include <string>
#include <cstdlib>
#include <wchar.h>

class WstringAdapter {
public:
    WstringAdapter(const wchar_t* ptr, size_t size, void* owner) : ptr((wchar_t*)ptr), size(size), owner(owner),
        original(ptr ? (wchar_t*)ptr : (wchar_t*)""), str(to_mbs(original, size)) { }

//    WstringAdapter(const signed   wchar_t* ptr, size_t size, void* owner) : ptr((wchar_t*)ptr), size(size), owner(owner),
//        wstr2(ptr ? (wchar_t*)ptr : ""), wstr(str2) { }
//
//    WstringAdapter(const unsigned wchar_t* ptr, size_t size, void* owner) : ptr((wchar_t*)ptr), size(size), owner(owner),
//        wstr2(ptr ? (wchar_t*)ptr : ""), wstr(str2) { }

    WstringAdapter(const std::wstring& str) : ptr(0), size(0), owner(0), original(str), str(to_mbs(original, size)) { }

    WstringAdapter(      std::wstring& str) : ptr(0), size(0), owner(0), original(str), str(to_mbs(original, size)) { }

    void assign(wchar_t* ptr, size_t size, void* owner) {
        this->ptr = ptr;
        this->size = size;
        this->owner = owner;
        original = ptr ? ptr : (wchar_t*)"";
        str = to_mbs(original, size);
    }

    static void deallocate(void* owner) {
        free(owner);
    }

    operator char*() {
//        const wchar_t * str = original.c_str();
//        char c_str[this->size];
//        std::wcstombs(c_str, str, this->size);
        const char* c_str = str.c_str();
        if (str_ptr == NULL || strcmp(c_str, str_ptr) != 0) {
            str_ptr = strdup(c_str);
        }
        size = strlen(c_str) + 1;
        owner = str_ptr;
        return str_ptr;
    }

    operator signed char*() {
        return (signed char*)(operator char*)();
    }

    operator unsigned char*() {
        return (unsigned char*)(operator char*)();
    }

    operator const char*() {
        return str.c_str();
    }

    operator const signed char*() {
        return (signed char*) str.c_str();
    }

    operator const unsigned char*() {
        return (unsigned char*) str.c_str();
    }

    operator std::wstring&() {
        return original;
    }

    operator std::wstring*() {
        return ptr ? &original : 0;
    }

    wchar_t* ptr;
    size_t size;
    void* owner;
    std::wstring original;
    std::string str;
    char* str_ptr;

private:
    static std::string to_mbs(std::wstring& wstr, size_t size) {
       const wchar_t * str = wstr.c_str();
       char c_str[size];
       std::wcstombs(c_str, str, size);
       return std::string(c_str);
    }
};
