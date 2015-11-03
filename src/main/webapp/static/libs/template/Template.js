define(function(){
    var Template = function(text, content) {
        var render,
            settings = {
                evaluate    : /<%([\s\S]+?)%>/g,
                interpolate : /<%=([\s\S]+?)%>/g,
                escape      : /<%-([\s\S]+?)%>/g
            },
            noMatch = /(.)^/,
            escapes = {
                "'":      "'",
                '\\':     '\\',
                '\r':     'r',
                '\n':     'n',
                '\t':     't',
                '\u2028': 'u2028',
                '\u2029': 'u2029'
            },
            escaper = /\\|'|\r|\n|\t|\u2028|\u2029/g,
            matcher = new RegExp([
                (settings.escape || noMatch).source,
                (settings.interpolate || noMatch).source,
                (settings.evaluate || noMatch).source
            ].join('|') + '|$', 'g'),
            index = 0,
            source = "__p+='";

        text.replace(matcher, function(match, escape, interpolate, evaluate, offset) {
            source += text.slice(index, offset)
                .replace(escaper, function(match) { return '\\' + escapes[match]; });

            if (escape) {
                source += "'+\n((__t=(" + escape + "))==null?'':_.escape(__t))+\n'";
            }
            if (interpolate) {
                source += "'+\n((__t=(" + interpolate + "))==null?'':__t)+\n'";
            }
            if (evaluate) {
                source += "';\n" + evaluate + "\n__p+='";
            }
            index = offset + match.length;
            return match;
        });
        source += "';\n";

        // If a variable is not specified, place data values in local scope.
        source = 'with(obj||{}){\n' + source + '}\n';
        source = "var __t,__p='',__j=Array.prototype.join," +
        "print=function(){__p+=__j.call(arguments,'');};\n" +
        source + "return __p;\n";
        try {
            render = new Function('obj', '_', source);
        } catch (e) {
            e.source = source;
            throw e;
        }
        var template = function(data) {
            return render.call(this, data,content);
        };
        // Provide the compiled function source as a convenience for precompilation.
        template.source = 'function(' + ('obj') + '){\n' + source + '}';

        return template;
    }
    return Template;
});