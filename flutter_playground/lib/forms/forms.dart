import 'package:flutter/material.dart';
import 'package:flutter_form_builder/flutter_form_builder.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:form_builder_validators/form_builder_validators.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Forms',
      home: HomePage(),
      localizationsDelegates: const [
        FormBuilderLocalizations.delegate,
        GlobalMaterialLocalizations.delegate,
        GlobalWidgetsLocalizations.delegate,
      ],
      supportedLocales: const [
        Locale('en', ''),
        Locale('ja', ''),
        Locale('pt', ''),
        Locale('sk', ''),
        Locale('pl', '')
      ],
    );
  }
}

class HomePage extends StatefulWidget {
  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  final _formKey = GlobalKey<FormBuilderState>();
  var genderOptions = ['Male', 'Female', 'Other'];
  void _onChanged(dynamic val) => debugPrint(val.toString());
  bool _ageHasError = false;
  @override
  void initState() {
    // TODO: implement initState
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text("Home"),
        ),
        body: Padding(
          padding: const EdgeInsets.all(8.0),
          child: FormBuilder(
            key: _formKey,
            autovalidateMode: AutovalidateMode.disabled,
            child: Column(children: <Widget>[
              FormBuilderCheckboxGroup<String>(
                autovalidateMode: AutovalidateMode.onUserInteraction,
                decoration: const InputDecoration(
                    labelText: 'The language of my people'),
                name: 'languages',
                // initialValue: const ['Dart'],
                options: const [
                  FormBuilderFieldOption(value: 'Dart'),
                  FormBuilderFieldOption(value: 'Kotlin'),
                  FormBuilderFieldOption(value: 'Java'),
                  FormBuilderFieldOption(value: 'Swift'),
                  FormBuilderFieldOption(value: 'Objective-C'),
                  FormBuilderFieldOption(value: 'Dart'),
                  FormBuilderFieldOption(value: 'Kotlin'),
                  FormBuilderFieldOption(value: 'Java'),
                  FormBuilderFieldOption(value: 'Swift'),
                  FormBuilderFieldOption(value: 'Objective-C'),
                  FormBuilderFieldOption(value: 'Dart'),
                  FormBuilderFieldOption(value: 'Kotlin'),
                  FormBuilderFieldOption(value: 'Java'),
                  FormBuilderFieldOption(value: 'Swift'),
                  FormBuilderFieldOption(value: 'Objective-C'),
                ],
                onChanged: _onChanged,
                separator: const VerticalDivider(
                  width: 10,
                  thickness: 5,
                  color: Colors.red,
                ),
                validator: FormBuilderValidators.compose([
                  FormBuilderValidators.minLength(context, 1),
                  FormBuilderValidators.maxLength(context, 3),
                ]),
              ),
              FormBuilderSwitch(
                title: const Text('I Accept the tems and conditions'),
                name: 'accept_terms_switch',
                initialValue: true,
                onChanged: _onChanged,
              ),
              FormBuilderSegmentedControl(
                decoration: const InputDecoration(
                  labelText: 'Movie Rating (Archer)',
                ),
                name: 'movie_rating',
                // initialValue: 1,
                // textStyle: TextStyle(fontWeight: FontWeight.bold),
                options: List.generate(5, (i) => i + 1)
                    .map((number) => FormBuilderFieldOption(
                          value: number,
                          child: Text(
                            number.toString(),
                            style: const TextStyle(fontWeight: FontWeight.bold),
                          ),
                        ))
                    .toList(),
                onChanged: _onChanged,
              ),
              FormBuilderRadioGroup<String>(
                decoration: const InputDecoration(
                  labelText: 'My chosen language',
                ),
                initialValue: null,
                name: 'best_language',
                onChanged: _onChanged,
                validator: FormBuilderValidators.compose(
                    [FormBuilderValidators.required(context)]),
                options: ['Dart', 'Kotlin', 'Java', 'Swift', 'Objective-C']
                    .map((lang) => FormBuilderFieldOption(
                          value: lang,
                          child: Text(lang),
                        ))
                    .toList(growable: false),
                controlAffinity: ControlAffinity.trailing,
              ),
              FormBuilderTextField(
                autovalidateMode: AutovalidateMode.always,
                name: 'age',
                decoration: InputDecoration(
                  labelText: 'Age',
                  suffixIcon: _ageHasError
                      ? const Icon(Icons.error, color: Colors.red)
                      : const Icon(Icons.check, color: Colors.green),
                ),
                onChanged: (val) {
                  setState(() {
                    _ageHasError =
                        !(_formKey.currentState?.fields['age']?.validate() ??
                            false);
                  });
                },
                // valueTransformer: (text) => num.tryParse(text),
                validator: FormBuilderValidators.compose([
                  FormBuilderValidators.required(context),
                  FormBuilderValidators.numeric(context),
                  FormBuilderValidators.max(context, 70),
                ]),
                // initialValue: '12',
                keyboardType: TextInputType.number,
                textInputAction: TextInputAction.next,
              ),
              FormBuilderCheckbox(
                name: 'accept_terms',
                initialValue: false,
                onChanged: _onChanged,
                title: RichText(
                  text: const TextSpan(
                    children: [
                      TextSpan(
                        text: 'I have read and agree to the ',
                        style: TextStyle(color: Colors.black),
                      ),
                      TextSpan(
                        text: 'Terms and Conditions',
                        style: TextStyle(color: Colors.blue),
                      ),
                    ],
                  ),
                ),
                validator: FormBuilderValidators.equal(
                  context,
                  true,
                  errorText: 'You must accept terms and conditions to continue',
                ),
              ),
              FormBuilderDateTimePicker(
                name: 'date',
                initialValue: DateTime.now(),
                inputType: InputType.time,
                decoration: InputDecoration(
                  labelText: 'Appointment Time',
                  suffixIcon: IconButton(
                      icon: const Icon(Icons.close),
                      onPressed: () {
                        _formKey.currentState!.fields['date']?.didChange(null);
                      }),
                ),
                initialTime: const TimeOfDay(hour: 8, minute: 0),
                //locale: const Locale.fromSubtags(languageCode: 'hi'),
              ),
              /*FormBuilderDateRangePicker(
                name: 'date_range',
                firstDate: DateTime(2021),
                lastDate: DateTime(2030),
                format: DateFormat('yyyy-MM-dd'),
                onChanged: _onChanged,
                decoration: InputDecoration(
                  labelText: 'Date Range',
                  helperText: 'Helper text',
                  hintText: 'Hint text',
                  suffixIcon: IconButton(
                      icon: const Icon(Icons.close),
                      onPressed: () {
                        _formKey.currentState!.fields['date_range']
                            ?.didChange(null);
                      }),
                ),
              ),*/
              FormBuilderFilterChip(
                name: 'filter_chip',
                decoration: const InputDecoration(
                  labelText: 'Select many options',
                ),
                options: const [
                  FormBuilderFieldOption(value: 'Test', child: Text('Test')),
                  FormBuilderFieldOption(
                      value: 'Test 1', child: Text('Test 1')),
                  FormBuilderFieldOption(
                      value: 'Test 2', child: Text('Test 2')),
                  FormBuilderFieldOption(
                      value: 'Test 3', child: Text('Test 3')),
                  FormBuilderFieldOption(
                      value: 'Test 4', child: Text('Test 4')),
                ],
              ),
              FormBuilderDropdown(
                name: 'gender',
                decoration: const InputDecoration(
                  labelText: 'Gender',
                ),
                // initialValue: 'Male',
                allowClear: true,
                hint: const Text('Select Gender'),
                validator: FormBuilderValidators.compose(
                    [FormBuilderValidators.required(context)]),
                items: genderOptions
                    .map((gender) => DropdownMenuItem(
                          value: gender,
                          child: Text('$gender'),
                        ))
                    .toList(),
              ),
              Row(
                children: <Widget>[
                  Expanded(
                    child: MaterialButton(
                      color: Theme.of(context).colorScheme.secondary,
                      child: const Text(
                        "Submit",
                        style: TextStyle(color: Colors.white),
                      ),
                      onPressed: () {
                        _formKey.currentState?.save();
                        if (_formKey.currentState!.validate()) {
                          print(_formKey.currentState?.value);
                        } else {
                          print("validation failed");
                        }
                      },
                    ),
                  ),
                  const SizedBox(width: 20),
                  Expanded(
                    child: MaterialButton(
                      color: Theme.of(context).colorScheme.secondary,
                      child: const Text(
                        "Reset",
                        style: TextStyle(color: Colors.white),
                      ),
                      onPressed: () {
                        _formKey.currentState?.reset();
                      },
                    ),
                  ),
                ],
              )
            ]),
          ),
        ));
  }
}
